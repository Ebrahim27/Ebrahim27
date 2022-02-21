package com.eki.ee.realbank.controller;


import com.eki.ee.realbank.utils.YesNo;
import lombok.Data;
import java.util.Date;

@Data
public class BaseDto {
   private static final long serialVersionUID = 1L;


   private String  accountName ;
   private String  accountFamilyName ;
   private Integer accountNumber ;
   private Integer accountBalanceAmount ;
   private Integer fromAccountNumber ;
   private Integer toAccountNumber ;
   private Integer amountMoney ;
   private YesNo  hasTransaction ;
   private Date  date;

   public BaseDto (){}
}
