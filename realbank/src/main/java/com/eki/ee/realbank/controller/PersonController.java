package com.eki.ee.realbank.controller;


import com.eki.ee.realbank.domain.account.Account;
import com.eki.ee.realbank.domain.account.AccountInput;
import com.eki.ee.realbank.domain.bankTransaction.BankTransaction;
import com.eki.ee.realbank.domain.bankTransaction.BankTransactionInput;
import com.eki.ee.realbank.domain.person.Person;
import com.eki.ee.realbank.domain.person.PersonInput;
import com.eki.ee.realbank.service.account.AccountService;
import com.eki.ee.realbank.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/bank")
@Controller
// controller class which makes HTTP api
public class PersonController {

    @Autowired
    PersonService personService ;

    @Autowired
    AccountService accountService ;




    //  person creation method
    @PostMapping(value = "createPerson", headers = "Accept=application/json;charset = UTF-8")
    public ResponseEntity person (
            @RequestBody PersonInput input ) throws Exception {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.personService.createPerson(input));
        }

    //  account creation method
    @PostMapping(value = "createAccount", headers = "Accept=application/json;charset = UTF-8")
    public ResponseEntity account (
            @RequestBody AccountInput input ) throws Exception {
            return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.personService.createAccount(input));
    }

    //  bank transaction process method
    @PostMapping(value = "bankTransaction", headers = "Accept=application/json;charset = UTF-8")
    public ResponseEntity bankTransaction (
            @RequestBody BankTransactionInput input ) throws Exception {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.personService.bankTransaction(input));
          }

    //  this method creates deposit process
    @PostMapping(value = "deposit", headers = "Accept=application/json;charset = UTF-8")
    public ResponseEntity deposit (
            @RequestBody BankTransactionInput input ) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.personService.deposit(input));
    }


    //  this method creates withdraw process
    @PostMapping(value = "withdraw", headers = "Accept=application/json;charset = UTF-8")
    public ResponseEntity withdraw (
            @RequestBody BankTransactionInput  input ) throws Exception {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.personService.withdraw(input));
    }

    //   this method creates accountUpdate process
    @PutMapping(headers = "Accept=application/json;charset=UTF-8")
    public ResponseEntity<BaseDto> update(
            @RequestBody PersonInput  input) throws Exception {
        return new ResponseEntity(personService.updatePerson(input) , HttpStatus.CREATED);
    }


    //   this method deletes bank accountNumber
    @DeleteMapping(value = "/{accountNumber}", headers = "Accept=application/json;charset=UTF-8")
    public ResponseEntity < HttpStatus > delete ( @PathVariable("accountNumber") Integer accountNumber ) throws Exception {
        personService.deleteAccount(accountNumber);
            return new ResponseEntity<>(HttpStatus.OK);
      }


    //  this method reads accounts
    @GetMapping(value = "/accounts", headers = "Accept=application/json;charset=UTF-8")
    public ResponseEntity <Account>  getAllAccounts() throws Exception {
        return new ResponseEntity( personService.findAllAccounts(), HttpStatus.OK);
      }
  }