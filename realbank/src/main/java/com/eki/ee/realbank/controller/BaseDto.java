package com.eki.ee.realbank.controller;



import com.eki.ee.realbank.domain.account.Account;
import lombok.Data;
import java.util.Date;
import java.util.List;


@Data
public class BaseDto {
   private static final long serialVersionUID = 1L;

   private Long     id ;
   private String   personName ;
   private String   personLastName ;
   private Integer  personSocialCode ;
   private String   personPhoneNumber ;
   private String   personAddress ;
   private List < Account > accounts;

   private Integer  fromAccountNumber ;
   private Integer  toAccountNumber ;
   private Integer  transferMoneyAmount ;
   private Integer  depositAmount ;
   private Integer  withdrawAmount ;
   private Date     date ;

   private Long      personId ;
   private Integer   accountNumber ;
   private Integer   accountBalanceAmount;
   private Integer   accountInterestRate ;
   private String    accountType ;
   private Date     createdAt ;

   public BaseDto (){
      super();
      // TODO Auto-generated constructor stub
   }
}
