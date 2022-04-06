package com.eki.ee.realbank.domain.person;

;
import com.eki.ee.realbank.controller.BaseDto;
import com.eki.ee.realbank.domain.account.Account;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Data
public class PersonOutput extends BaseDto {
     Long     id ;
     String   personName ;
     String   personLastName ;
     Integer  personSocialCode ;
     String   personPhoneNumber ;
     String   personAddress ;
     public  List < Account > accounts;


   public PersonOutput (
                         Long    id,
                         String  personName,
                         String  personLastName,
                         Integer personSocialCode,
                         String  personPhoneNumber ,
                         String  personAddress

    ) {
        this.id = id;
        this.personName = personName;
        this.personLastName = personLastName;
        this.personSocialCode = personSocialCode;
        this.personPhoneNumber = personPhoneNumber;
        this.personAddress= personAddress ;

      }
   }

