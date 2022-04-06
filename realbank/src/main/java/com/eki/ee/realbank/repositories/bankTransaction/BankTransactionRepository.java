package com.eki.ee.realbank.repositories.bankTransaction;


import com.eki.ee.realbank.domain.bankTransaction.BankTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BankTransactionRepository extends JpaRepository < BankTransaction , Integer >, JpaSpecificationExecutor <BankTransaction> {

    List < BankTransaction > findAll ();

}