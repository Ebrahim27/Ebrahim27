package com.eki.ee.realbank.domain.bankTransaction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BankTransactionInput {

        private Long     id ;
        private Integer  fromAccountNumber ;
        private Integer  toAccountNumber ;
        private Integer  transferMoneyAmount ;
        private Integer  depositAmount ;
        private Integer  withdrawAmount ;
        private Date     date ;


    }

