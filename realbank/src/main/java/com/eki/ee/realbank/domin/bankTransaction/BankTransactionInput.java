package com.eki.ee.realbank.domin.bankTransaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankTransactionInput {

        private Long id ;
        private Integer  fromAccountNumber ;
        private Integer  toAccountNumber ;
        private Integer  amountMoney ;
        private Date  date ;

    }

