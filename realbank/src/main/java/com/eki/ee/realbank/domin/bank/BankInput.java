package com.eki.ee.realbank.domin.bank;

import lombok.Data;

import java.util.Date;


@Data
public class BankInput {
    private Long id ;
    private String accountName ;
    private String accountFamilyName ;
    private Integer accountNumber ;
    private Integer accountBalanceAmount ;
    private Date date ;

}
