package com.eki.ee.realbank.domain.bankTransaction;

import com.eki.ee.realbank.controller.BaseDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.Date;



@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BankTransactionOutput extends BaseDto {

     Long id ;
     Integer  fromAccountNumber ;
     Integer  toAccountNumber ;
     Integer  transferMoneyAmount;
     Integer  depositAmount ;
     Integer  withdrawAmount ;
     Date     date ;


        public BankTransactionOutput(
                                     Long id,
                                     Integer    fromAccountNumber,
                                     Integer    toAccountNumber,
                                     Integer    transferMoneyAmount,
                                     Integer    depositAmount,
                                     Integer    withdrawAmount,
                                     Date       date
        ) {

            this.id = id;
            this.fromAccountNumber = fromAccountNumber;
            this.toAccountNumber = toAccountNumber;
            this. transferMoneyAmount = transferMoneyAmount;
            this.depositAmount = depositAmount;
            this.withdrawAmount = withdrawAmount ;
            this.date = date ;
        }
    public BankTransactionOutput() {}
    }

