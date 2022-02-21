package com.eki.ee.realbank.domin.bank;

import com.eki.ee.realbank.utils.YesNo;
import com.eki.ee.realbank.controller.BaseDto;
import lombok.Data;

import java.util.Date;

@Data
public class BankOutput extends BaseDto {
     Long id;
     String accountName;
     String accountFamilyName;
     Integer accountNumber;
     Integer accountBalanceAmount ;
     Date date ;


    public BankOutput () {}


   public BankOutput( Long id,
                      String  accountName,
                      String  accountFamilyName,
                      Integer accountNumber,
                      Integer  accountBalanceAmount ,
                       Date date ,
                      YesNo hasTransaction
    ) {
        this.id = id;
        this.accountName = accountName;
        this.accountFamilyName = accountFamilyName;
        this.accountNumber = accountNumber;
        this.accountBalanceAmount = accountBalanceAmount;
        this.date = date ;
      }
   }

