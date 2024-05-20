import java.text.DecimalFormat;
import java.util.Date;

public class PayCard {
    private String Number;
    private String Owner;
    private double Balance;
    private Date DateGet;
    private boolean isBlocked;

    public PayCard(String Number, String Owner, double Balance, Date DateGet){
        this.Number = Number;
        this.Owner = Owner;
        this.Balance = Balance;
        this.DateGet = DateGet;
    }

    public PayCard(String Number, String Owner){
        this.Number = Number;
        this.Owner = Owner;
        this.Balance = 0;
        this.DateGet = new Date();
    }







}
