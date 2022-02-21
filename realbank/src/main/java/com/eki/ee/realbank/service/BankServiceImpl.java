package com.eki.ee.realbank.service;
import com.eki.ee.realbank.controller.BaseDto;
import com.eki.ee.realbank.domin.bank.Bank;
import com.eki.ee.realbank.domin.bank.BankInput;
import com.eki.ee.realbank.domin.bankTransaction.BankTransaction;
import com.eki.ee.realbank.domin.bankTransaction.BankTransactionInput;
import com.eki.ee.realbank.repositories.bank.BankRepository;
import com.eki.ee.realbank.repositories.bankTransaction.BankTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Date;


@Service
public class BankServiceImpl implements BankService {


    @Autowired
    BankRepository bankRepository ;


    @Autowired
    BankTransactionRepository bankTransactionRepository ;



    @Override  // this method  creates account in bank
    public String createBankAccount ( BankInput input  ) throws Exception {
         Date currentDate = new Date() ;
         Bank createAccount = new Bank().fromDto(input);
         createAccount.setDate(currentDate);
         bankRepository.save(createAccount);
   return "created" ;
      }




    @Override
    public void save ( BankInput input) {
        bankRepository.findBankIdByAccountNumber(input.getAccountNumber()) ;
        }




    @Override     //  bank transaction process
    public Long bankTransaction ( BankTransactionInput input  ) throws Exception {
        BankTransaction result = null;
        Bank fromAccount = bankRepository.findByAccountNumber(input.getFromAccountNumber())
                .orElseThrow(() -> new Exception(" شماره حساب مورد نظر یافت نشد !"));
        Bank toAccount = bankRepository.findByAccountNumber(input.getToAccountNumber())
                .orElseThrow(() -> new Exception(" شماره حساب مورد نظر یافت نشد !"));
        Date currentDate = new Date() ;
        BankTransaction bankTransaction = new BankTransaction();
        if ( fromAccount.getAccountBalanceAmount() != null  &&  fromAccount.getAccountBalanceAmount() >= input.getAmountMoney() -1 )
            try {
                Integer fromBalance , toBalance ;
                fromBalance  = fromAccount.getAccountBalanceAmount();
                toBalance =  toAccount.getAccountBalanceAmount() ;
                fromBalance -= input.getAmountMoney();
                toBalance += input.getAmountMoney();
                fromAccount.setAccountBalanceAmount( fromBalance);
                toAccount.setAccountBalanceAmount(toBalance);
                bankTransaction.setDate(currentDate) ;
                bankTransaction.setAmountMoney(input.getAmountMoney());
                bankTransaction.setFromAccountNumber(fromAccount.getAccountNumber());
                bankTransaction.setToAccountNumber(toAccount.getAccountNumber());
                result =bankTransactionRepository.save(bankTransaction);
            } catch (Exception e) {
                throw new IOException(" خطا!   موجودی کافی نمی باشد. ") ;
            }
        bankTransactionRepository.save(bankTransaction) ;
        return result.getId();
      }


    @Override   //  updating bank accounts
    public String  bankUpdate ( BankInput bankInput  ) throws Exception {
        Date currentDate = new Date();
        Bank updateAccount = new Bank().fromDto(bankInput);
        updateAccount.setDate(currentDate) ;
        bankRepository.save(updateAccount);
        return "updated" ;
    }


    @Override    //  reading the bank accounts
    public BaseDto getBankData ( Long  bankId ) throws Exception {
        if (bankId != null)
            try {
                Bank accountId = bankRepository.getOne(bankId) ;
                return accountId.toDto() ;
             } catch (Exception e){
                throw new IOException(" خطا!   اشتراکی یافت نشد . ") ;
          }
        return null ;
       }


    @Override    // deleting the bank id which show a row in table
    public HttpStatus deleteOne( Long id )  {
      bankRepository.deleteById(id);
      return HttpStatus.OK;
     }
  }










