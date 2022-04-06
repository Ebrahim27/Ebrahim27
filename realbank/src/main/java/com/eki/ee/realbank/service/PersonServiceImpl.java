package com.eki.ee.realbank.service;

import com.eki.ee.realbank.domain.account.Account;
import com.eki.ee.realbank.domain.account.AccountInput;
import com.eki.ee.realbank.domain.person.Person;
import com.eki.ee.realbank.domain.person.PersonInput;
import com.eki.ee.realbank.domain.bankTransaction.BankTransaction;
import com.eki.ee.realbank.domain.bankTransaction.BankTransactionInput;
import com.eki.ee.realbank.domain.person.PersonOutput;
import com.eki.ee.realbank.exceptions.ResourceNotFoundException;
import com.eki.ee.realbank.repositories.account.AccountRepository;
import com.eki.ee.realbank.repositories.person.PersonRepository;
import com.eki.ee.realbank.repositories.bankTransaction.BankTransactionRepository;
import com.eki.ee.realbank.service.account.AccountService;
import com.eki.ee.realbank.service.person.PersonService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;



@Transactional
@Service
public class PersonServiceImpl implements PersonService , AccountService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AccountRepository accountRepository ;

    @Autowired
    BankTransactionRepository bankTransactionRepository;





    @Override                               // creating people
    public String createPerson ( PersonInput input ) throws Exception {
       Person createPerson = new Person().fromDto(input);
        if( input.getPersonName() == null ) {
            throw new Exception("نام صاحب حساب خالی است");
        }
        if(input.getPersonLastName() == null){
            throw new Exception("نام خانوادگی صاحب حساب خالی است") ;
        }
        if(input.getPersonSocialCode() == null){
            throw new Exception(" شماره ملی خالی است") ;
        }
        if(input.getPersonPhoneNumber() == null){
            throw new Exception(" شماره موبایل خالی است") ;
        }
        if(input.getPersonAddress()== null){
            throw new Exception("آدرس خالی است ") ;
        }
            personRepository.save(createPerson);
        return "created";
     }

    @Override                                  //updating people
    public PersonOutput updatePerson ( PersonInput input ) throws Exception {
        Person  person = personRepository.findById(input.getId())
                .orElseThrow(() -> new ResourceNotFoundException("personId", input.getId()));
        Person createPerson = new Person().fromDto(input);
        personRepository.save(createPerson);
        return  person.toDto() ;
    }


    @Override                                    //  creating account
    public Long createAccount ( AccountInput input ) throws Exception {
        Date currentDate = new Date();
        Person person = personRepository.findById(input.getPersonId())
                .orElseThrow(() -> new Exception("خطا!  شخصی  یافت نشد."));
            Account creatAccount = new Account().fromDto(input);
            creatAccount.setPersonId(person);
            creatAccount.setCreatedAt(currentDate);
            if(input.getPersonId() == null) {
                throw new Exception ("شخصی انتخاب نشده است") ;
            }
            if(input.getAccountNumber() == null){
                throw new Exception ("شماره حساب خالی است") ;
            }
            if(input.getAccountBalanceAmount() == null){
                throw new Exception ("مبلغ موجودی حساب خالی است") ;
            }
            if(input.getAccountType() == null) {
                throw new Exception ("نوع حساب خالی است") ;
            }
            if(input.getAccountInterestRate() == null){
                throw new Exception ("درصد سود حساب خالی است") ;
            }
            accountRepository.save(creatAccount);
            return creatAccount.getId();
    }


    @Override                                     //  bank transaction process
    public Long bankTransaction ( BankTransactionInput input ) throws Exception {
        BankTransaction result = null;
        Account fromAccount = accountRepository.findByAccountNumber(input.getFromAccountNumber())
                .orElseThrow(() -> new Exception(" شماره حساب مورد نظر یافت نشد !"));
        Account toAccount = accountRepository.findByAccountNumber(input.getToAccountNumber())
                .orElseThrow(() -> new Exception(" شماره حساب مورد نظر یافت نشد !"));
        Date currentDate = new Date();
        BankTransaction bankTransaction = new BankTransaction();
        if (input.getFromAccountNumber() == null )
            throw new Exception("شماره حساب مبدا خالی است") ;
        if (input.getToAccountNumber() == null )
            throw new Exception("شماره حساب مقصد خالی است") ;
        if (fromAccount.getAccountBalanceAmount() != null  &&  fromAccount.getAccountBalanceAmount() >= input.getTransferMoneyAmount() - 1)
            try {
                Integer  fromBalance, toBalance;
                fromBalance = fromAccount.getAccountBalanceAmount();
                toBalance = toAccount.getAccountBalanceAmount();
                fromBalance -= input.getTransferMoneyAmount();
                toBalance += input.getTransferMoneyAmount();
                fromAccount.setAccountBalanceAmount(fromBalance);
                toAccount.setAccountBalanceAmount(toBalance);
                bankTransaction.setDate(currentDate);
                bankTransaction.setTransferMoneyAmount(input.getTransferMoneyAmount());
                bankTransaction.setFromAccountNumber(fromAccount.getAccountNumber());
                bankTransaction.setToAccountNumber(toAccount.getAccountNumber());
                result = bankTransactionRepository.save(bankTransaction);
            } catch (Exception e) {
                throw new Exception(" خطا!   موجودی کافی نمی باشد. ");
            }
        bankTransactionRepository.save(bankTransaction);
        return result.getId();
    }


    @Override                                       //account deposit
    public Integer deposit( BankTransactionInput input ) throws Exception {
        Account depositTo = accountRepository.findByAccountNumber(input.getToAccountNumber())
                .orElseThrow(() -> new Exception("  شماره حساب مورد نظر یافت نشد !"));
        BankTransaction depositResult = null ;
        Date currentDate = new Date();
        BankTransaction bankTransaction = new BankTransaction();
        if (depositTo.getAccountNumber() == null)
            throw new Exception("شماره حساب خالی است") ;
        if ( input.getDepositAmount() == null )
            throw new Exception("مبلغ واریز خالی است") ;
        if (input.getDepositAmount() <= 0 )
            throw new Exception("مبلغ واریز نامعتبر است!") ;
        if ( depositTo.getAccountBalanceAmount() !=  null )
            try {
                Integer  accountBalance =  depositTo.getAccountBalanceAmount() ;
                accountBalance += input.getDepositAmount() ;
                bankTransaction.setToAccountNumber(depositTo.getAccountNumber());
                bankTransaction.setDepositAmount(input.getDepositAmount());
                depositTo.setAccountBalanceAmount(accountBalance) ;
                bankTransaction.setDate(currentDate) ;
                depositResult = bankTransactionRepository.save(bankTransaction) ;
            }catch (Exception ex){
                throw new Exception("خطا!   حساب مورد نظر غیر فعال است!") ;
            }
        bankTransactionRepository.save(bankTransaction) ;
        return depositResult.getDepositAmount() ;
    }

    @Override                                  // withdraw  process
    public Integer  withdraw ( BankTransactionInput input ) throws Exception {
          Account withdrawFrom = accountRepository.findByAccountNumber(input.getFromAccountNumber())
                .orElseThrow(() -> new Exception("  شماره حساب مورد نظر یافت نشد !"));
           BankTransaction withdrawResult = null ;
          Date currentDate = new Date () ;
          BankTransaction bankTransaction = new BankTransaction();
          if ( input.getFromAccountNumber() == null )
              throw new Exception("شماره حساب خالی است") ;
          if (input.getWithdrawAmount() == null )
              throw new Exception("مبلغ برداشت خالی است");
          if (input.getWithdrawAmount() <= 0 )
              throw new Exception("مبلغ برداشت نامعتبر است!") ;
          if ( withdrawFrom.getAccountBalanceAmount() != null  &&  withdrawFrom.getAccountBalanceAmount() > input.getWithdrawAmount() -1 )
              try {
                  Integer accountBalance = withdrawFrom.getAccountBalanceAmount() ;
                  accountBalance -= input.getWithdrawAmount() ;
                  bankTransaction.setFromAccountNumber(withdrawFrom.getAccountNumber());
                  bankTransaction.setWithdrawAmount(input.getWithdrawAmount());
                  withdrawFrom.setAccountBalanceAmount(accountBalance);
                  bankTransaction.setDate(currentDate) ;
                 withdrawResult = bankTransactionRepository.save(bankTransaction) ;
              }catch( Exception ex){
                  throw new Exception("موجودی کافی نمی باشد!") ;
              }
        bankTransactionRepository.save(bankTransaction) ;
        return withdrawResult.getWithdrawAmount();
    }


    @SneakyThrows
    @Override                       //deleting an account
    public HttpStatus deleteAccount ( Integer accountNumber ) {
        if(accountRepository.findByAccountNumber(accountNumber).get() == null)
            throw new Exception("شماره حساب یافت نشد!") ;
        accountRepository.delete(accountRepository.findByAccountNumber(accountNumber).get());
        return HttpStatus.OK;
        }


    @Override                          // reading all accounts
    public List < Account > findAllAccounts () throws Exception {
        return accountRepository.findAll() ;
    }
}










