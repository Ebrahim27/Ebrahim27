package com.eki.ee.realbank.controller;


import com.eki.ee.realbank.domin.bank.BankInput;
import com.eki.ee.realbank.domin.bankTransaction.BankTransactionInput;
import com.eki.ee.realbank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/bank")
@Controller
// controller class which makes HTTP (request-respond)   methods
public class BankController {

    @Autowired
    BankService bankService ;


//  this method creates bank accounts
    @PostMapping (value = "createBankAccount" , headers = "Accept=application/json;charset = UTF-8")
    public ResponseEntity bank(
        @RequestBody BankInput input ) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.bankService.createBankAccount( input  ));
        }
        catch (Exception e ) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(e.getMessage()) ;
        }
    }


//  this method creates bank accounts which contains some properties
    @PostMapping (value = "bankTransaction" , headers = "Accept=application/json;charset = UTF-8")
    public ResponseEntity bankTransaction(
            @RequestBody BankTransactionInput input ) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.bankService.bankTransaction ( input ) );
        }
        catch (Exception e ) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(e.getMessage()) ;
        }
    }


//  this method reads bank table and updates account
        @PutMapping ( headers = "Accept=application/json;charset = UTF-8")
        public ResponseEntity<BaseDto> bankUpdate(
                @RequestBody BankInput  bankInput ) throws Exception {
            bankService.bankUpdate(bankInput) ;
       return new ResponseEntity <>( HttpStatus.CREATED) ;
        }


//   this method reads bank id
    @GetMapping (headers = "Accept=application/json;charset = UTF-8")
    public ResponseEntity<BaseDto> view (@RequestParam(name = "id") Long id) throws Exception {
             return new ResponseEntity<>(bankService.getBankData(id), HttpStatus.OK ) ;
       }


//   this method deletes bank id
    @DeleteMapping(headers = "Accept=application/json;charset=UTF-8")
    public HttpStatus delete(@RequestParam(value = "id") long id) throws Exception {
        return bankService.deleteOne(id);
     }
   }
