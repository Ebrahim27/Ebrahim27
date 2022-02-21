package com.eki.ee.realbank.domin.bankTransaction;
import com.eki.ee.realbank.domin.bank.Bank;
import com.eki.ee.realbank.domin.bank.BankInput;
import com.eki.ee.realbank.domin.bank.BankOutput;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "tbl_bank_transaction")
public class BankTransaction{
    @javax.persistence.Id
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BANK_TRANSACTION")
    @SequenceGenerator(name = "SEQ_BANK_TRANSACTION", sequenceName = "BANK_TRANSACTION ", allocationSize = 1)
    private Long id ;

    @Column(name = "FROM_ACCOUNT_NUMBER")
    private Integer  fromAccountNumber ;

    @Column(name = "TO_ACCOUNT_NUMBER")
    private Integer  toAccountNumber ;

    @Column(name = "AMOUNT_MONEY")
    private Integer amountMoney ;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "DATE")
    private Date date ;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "BANK_ID", referencedColumnName = "ID")
    private List <BankTransaction> bankTransactions = new ArrayList  <>();




    public BankTransactionOutput toDto (){
        BankTransactionOutput output = new BankTransactionOutput();
        output.setId(id);
        output.setFromAccountNumber(fromAccountNumber);
        output.setToAccountNumber(toAccountNumber);
        output.setAmountMoney(amountMoney);
        output.setDate(date) ;
        return output;
    }


    public BankTransaction fromDto (BankTransactionInput input ){
        BankTransaction bankTransaction = new BankTransaction ();
        bankTransaction.setId(input.getId());
        bankTransaction.setFromAccountNumber(input.getFromAccountNumber());
        bankTransaction.setToAccountNumber(input.getToAccountNumber());
        bankTransaction.setAmountMoney(input.getAmountMoney());
        bankTransaction.setDate(input.getDate());
        return bankTransaction ;

    }









//    public BankTransaction(BankTransactionInput input ){
//        bankTransactionInput (input) ; }
//    public void bankTransactionInput(BankTransactionInput input ) {
//        input.setId(input.getId());
//        input.setFromAccountNumber(input.getFromAccountNumber());
//        input.setToAccountNumber(input.getToAccountNumber());
//        input.setAmountMoney(input.getAmountMoney());
//        input.setDate(input.getDate()) ;
//    }
//    public BankTransactionOutput output (){
//        BankTransactionOutput output = new BankTransactionOutput();
//        output.setId(id);
//        output.setFromAccountNumber(fromAccountNumber);
//        output.setToAccountNumber(toAccountNumber);
//        output.setAmountMoney(amountMoney);
//        output.setDate(date);
//        return output;
//    }
}
