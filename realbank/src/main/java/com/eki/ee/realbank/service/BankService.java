package com.eki.ee.realbank.service;


import com.eki.ee.realbank.controller.BaseDto;
import com.eki.ee.realbank.domin.bank.BankInput;
import com.eki.ee.realbank.domin.bankTransaction.BankTransactionInput;
import com.sun.net.httpserver.HttpServer;
import org.springframework.http.HttpStatus;
import sun.net.httpserver.HttpServerImpl;

public interface BankService {

    String createBankAccount (BankInput input) throws Exception;

    void save ( BankInput input )  throws Exception ;

    Long bankTransaction ( BankTransactionInput input ) throws Exception;

    BaseDto getBankData ( Long  bankId) throws Exception;

    String  bankUpdate( BankInput bankInput ) throws Exception;

    HttpStatus deleteOne( Long Id ) ;

}
