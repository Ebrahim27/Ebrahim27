package com.eki.ee.realbank.domain.bankTransaction;
import com.eki.ee.realbank.domain.account.Account;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.*;


@JsonIgnoreProperties
@NoArgsConstructor
@Entity
@Data
@Table(name = "BANK_TRANSACTION")
public class BankTransaction{
    @javax.persistence.Id
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "SEQ_BANK_TRANSACTION")
    @SequenceGenerator(name = "SEQ_BANK_TRANSACTION", sequenceName = "BANK_TRANSACTION ", allocationSize = 1)
    private Long id ;

    @Column(name = "FROM_ACCOUNT_NUMBER")
    private Integer  fromAccountNumber ;

    @Column(name = "TO_ACCOUNT_NUMBER")
    private Integer  toAccountNumber ;

    @Column(name = "TRANSFER_MONEY_AMOUNT")
    private Integer transferMoneyAmount ;

    @Column(name = "DEPOSIT_AMOUNT")
    private  Integer  depositAmount ;

    @Column(name = "WITHDRAW_AMOUNT")
    private Integer withdrawAmount;

    @DateTimeFormat(pattern = "yyyy-MM -dd hh:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "DATE")
    private Date date ;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @OneToMany( fetch = FetchType.LAZY )
    private List < Account > accounts ;


    public BankTransactionOutput toDto (){
        BankTransactionOutput output = new BankTransactionOutput();
        output.setId(id);
        output.setFromAccountNumber(fromAccountNumber);
        output.setToAccountNumber(toAccountNumber);
        output.setTransferMoneyAmount(transferMoneyAmount);
        output.setDepositAmount(depositAmount);
        output.setWithdrawAmount(withdrawAmount);
        output.setDate(date) ;
        return output;
    }

    public BankTransaction fromDto (BankTransactionInput input ){
        BankTransaction bankTransaction = new BankTransaction ();
        bankTransaction.setId(input.getId());
        bankTransaction.setFromAccountNumber(input.getFromAccountNumber());
        bankTransaction.setToAccountNumber(input.getToAccountNumber());
        bankTransaction.setTransferMoneyAmount(input.getTransferMoneyAmount());
        bankTransaction.setDepositAmount(input.getDepositAmount());
        bankTransaction.setWithdrawAmount(input.getWithdrawAmount());
        bankTransaction.setDate(input.getDate());
        return bankTransaction ;
      }
  }
