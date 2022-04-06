package com.eki.ee.realbank.domain.account;
import com.eki.ee.realbank.domain.person.Person;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "ACCOUNT" )
public class Account {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ACCOUNT")
    @SequenceGenerator(name = "SEQ_ACCOUNT", sequenceName = "SEQ_ACCOUNT", allocationSize = 1)
    private long id;

    @Column(name = "ACCOUNT_NUMBER")
    private Integer  accountNumber;

    @Column(name = "ACCOUNT_BALANCE_AMOUNT")
    private Integer  accountBalanceAmount;

    @Column(name = "ACCOUNT_INTEREST_RATE" )
    private Integer  accountInterestRate ;

    @Column(name = "ACCOUNT_TYPE")
    private String  accountType ;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "CREATED_AT")
    private Date createdAt ;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "PERSON_ID" , referencedColumnName = "ID")
    private Person personId;



    public AccountOutput toDto (){
        AccountOutput output = new AccountOutput();
        output.setId(id);
        output.setAccountNumber(accountNumber);
        output.setAccountBalanceAmount(accountBalanceAmount);
        output.setAccountInterestRate(accountInterestRate) ;
        output.setAccountType(accountType ) ;
        output.setCreatedAt(createdAt) ;
        return output;
    }


    public Account fromDto ( AccountInput input ){
        Account account = new Account();
        if (input.getId() != null)
            account.setId(input.getId());
        account.setAccountNumber(input.getAccountNumber());
        account.setAccountBalanceAmount(input.getAccountBalanceAmount());
        account.setAccountInterestRate(input.getAccountInterestRate());
        account.setAccountType(input.getAccountType());
        account.setCreatedAt(input.getCreatedAt());
        return account ;
      }
  }

