package com.eki.ee.realbank.repositories.bank;

import com.eki.ee.realbank.domin.bank.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;



@Repository
public interface BankRepository extends JpaRepository < Bank , Long  >, JpaSpecificationExecutor <Bank> {

// find out accounts numbers
    List<Bank> findBankIdByAccountNumber(@Param("accountNumber") Integer  accountNumber);
    Optional<Bank> findByAccountNumber(Integer accountNumber);


//  find out accounts id
     Bank getOne ( @Param("id") Long   id);



//  find out accounts id
     Bank findBankIdById ( @Param("BankId") Long   id) ;

}









