package com.eki.ee.realbank.domain.account;

import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
public class AccountInput {

    private Long      id ;
    private Integer   accountNumber ;
    private Integer   accountBalanceAmount;
    private Integer   accountInterestRate ;
    private String    accountType  ;
    private Integer   interest ;
    private Date      createdAt ;
    private List < Account > accounts;
    private Long     personId ;


}
