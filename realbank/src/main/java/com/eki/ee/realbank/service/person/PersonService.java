package com.eki.ee.realbank.service.person;


import com.eki.ee.realbank.domain.account.Account;
import com.eki.ee.realbank.domain.account.AccountInput;
import com.eki.ee.realbank.domain.bankTransaction.BankTransaction;
import com.eki.ee.realbank.domain.person.PersonInput;
import com.eki.ee.realbank.domain.bankTransaction.BankTransactionInput;
import com.eki.ee.realbank.domain.person.PersonOutput;
import org.springframework.http.HttpStatus;
import java.util.List;



public interface PersonService<I ,  O> {

    Long createAccount ( AccountInput input  ) throws Exception;

    String createPerson ( PersonInput input) throws Exception;

    Long bankTransaction ( BankTransactionInput input ) throws Exception;

    Integer withdraw (BankTransactionInput input) throws Exception;

    Integer deposit ( BankTransactionInput input ) throws Exception;

    HttpStatus deleteAccount( Integer  accountNumber )throws Exception;

    PersonOutput updatePerson ( PersonInput input ) throws Exception ;

    List < Account > findAllAccounts () throws Exception;

}
