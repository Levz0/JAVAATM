import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

public class PayCard {
    private String Number;
    private String Owner;
    private double Balance;
    private LocalDate DateGet;
    private boolean isBlocked;

    public PayCard(String Number, String Owner, double Balance, LocalDate DateGet){
        this.Number = Number;
        this.Owner = Owner;
        this.Balance = Balance;
        this.DateGet = DateGet;
    }

    public PayCard(String Number, String Owner){
        this.Number = Number;
        this.Owner = Owner;
        this.Balance = 0;

    }

    public double getBalance() {
        return Balance;
    }

    public String getOwner( ) {
        return Owner;
    }

    public LocalDate getDateGet( ) {
        return DateGet;
    }

    public void setBalance(double balance){
        Balance = balance;
    }

    public void Deposit(double cashAmount){
        Balance = Balance + cashAmount;

    }

    public void WithdrawCash(double cashAmount){
        Balance = Balance - cashAmount;

    }
}
