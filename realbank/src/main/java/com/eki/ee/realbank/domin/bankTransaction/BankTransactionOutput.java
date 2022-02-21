package com.eki.ee.realbank.domin.bankTransaction;

import com.eki.ee.realbank.controller.BaseDto;
import lombok.Data;
import java.util.Date;


@Data
public class BankTransactionOutput extends BaseDto {

     Long id ;
     Integer  fromAccountNumber ;
     Integer  toAccountNumber ;
     Integer  amountMoney ;
     Date  date ;


    public BankTransactionOutput() {}


        public BankTransactionOutput(Long id,
                                     Integer  fromAccountNumber,
                                     Integer  toAccountNumber,
                                     Integer    amountMoney,
                                      Date   date

        ) {

            this.id = id;
            this.fromAccountNumber = fromAccountNumber;
            this.toAccountNumber = toAccountNumber;
            this.amountMoney = amountMoney;
            this.date = date ;

        }
    }

