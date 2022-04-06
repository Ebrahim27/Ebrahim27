package com.eki.ee.realbank.domain.account;
import com.eki.ee.realbank.controller.BaseDto;
import com.eki.ee.realbank.domain.person.Person;
import com.eki.ee.realbank.domain.person.PersonOutput;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;



@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Data
public class AccountOutput extends BaseDto {

    private Long       id ;
    private Integer    accountNumber ;
    private Integer    accountBalanceAmount;
    private Integer    accountInterestRate ;
    private String     accountType  ;
    private Integer    interest ;
    private Date       createdAt ;
    private List < Account > accounts ;
    private PersonOutput personOutput ;


    public AccountOutput (
                          Long    id ,
                          Integer accountNumber,
                          Integer  accountBalanceAmount ,
                          Integer  accountInterestRate ,
                          String  accountType ,
                          Person  personOutput ,
                          Integer  interest ,
                          Date    createdAt
    ) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.accountBalanceAmount = accountBalanceAmount;
        this.accountInterestRate = accountInterestRate;
        this.accountType = accountType;
        this.interest = interest ;
        this.createdAt = createdAt ;
        this.personOutput = personOutput.toDto();
       }
   }

