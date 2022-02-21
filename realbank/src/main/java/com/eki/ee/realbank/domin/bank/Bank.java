package com.eki.ee.realbank.domin.bank;


import com.fasterxml.jackson.annotation.JsonFormat ;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "tbl_bank" )
public class Bank {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_BANK")
    @SequenceGenerator(name = "SEQ_BANK", sequenceName = "SEQ_BANK", allocationSize = 1)
    private long id;

    @Column(name = "ACCOUNT_NAME")
    private String accountName;

    @Column(name = "ACCOUNT_FAMILY_NAME")
    private String accountFamilyName;

    @Column(name = "ACCOUNT_NUMBER")
    private Integer accountNumber ;

    @Column(name = "ACCOUNT_BALANCE_AMOUNT")
    private Integer  accountBalanceAmount ;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "DATE")
    private Date date ;




    public BankOutput toDto (){
        BankOutput output = new BankOutput();
        output.setId(id);
        output.setAccountName(accountName);
        output.setAccountFamilyName(accountFamilyName);
        output.setAccountNumber(accountNumber);
        output.setAccountBalanceAmount(accountBalanceAmount);
        output.setDate(date);
        return output;
      }


      public Bank fromDto ( BankInput input ){
         Bank bank = new Bank ();
         bank.setId(input.getId());
         bank.setAccountName(input.getAccountName());
         bank.setAccountFamilyName(input.getAccountFamilyName());
         bank.setAccountNumber(input.getAccountNumber());
         bank.setAccountBalanceAmount(input.getAccountBalanceAmount());
         bank.setDate(input.getDate());
         return bank ;

      }
  }
