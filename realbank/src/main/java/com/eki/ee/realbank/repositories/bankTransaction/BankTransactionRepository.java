package com.eki.ee.realbank.repositories.bankTransaction;


import com.eki.ee.realbank.domin.bankTransaction.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;




@Repository
public interface BankTransactionRepository extends JpaRepository < BankTransaction, Integer >, JpaSpecificationExecutor <BankTransaction> {

}