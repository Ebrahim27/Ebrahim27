Bank Process Application :


This application shows a Bank process , it will save account's information and their Transactions in H2  in-memory Database 
methods to call:

Post  =>    http://localhost:8080/api/bank/createBankAccount       this method creates a new account which has name , number , balance etc .

Post  =>    http://localhost:8080/api/bank/createBankAccount       creates a new account

Post  =>    http://localhost:8080/api/bank/createBankAccount       creates a new account

Get   =>    http://localhost:8080/api/bank?id=101&id=102                this method reads the bank account's

Post  =>   http://localhost:8080/api/bank/bankTransaction            this is transacional method 

Put   =>    http://localhost:8080/api/bank                                           this method updates Bank 

Delete => http://localhost:8080/api/bank?id=101                              this method dalates Bank account which Banker  could drop
 

Specification :     Java 8  ,  Spring boot 2.6.3  ,  lombok  , H2 database  ,  Spring web , Java Data JPA , IntelliJ  2020.1

h2  console URL  =>   http://localhost:8080/h2-console    UserName : sa     Password: 36   DatabaseName:  bankdb