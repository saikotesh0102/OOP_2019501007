import java.sql.Date;

public class BankAccount {
    String accountNumber;
    double balance;

    public void BankAccount(String accountNumber,double balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
}