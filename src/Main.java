import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class Main {

    public static void main(String[] args) {

        CardFrame cardFrame = new CardFrame();
        cardFrame.isVisible();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy");
        LocalDate GetDate = LocalDate.parse("12.15.2015", formatter);


        PayCard Card1 = new PayCard("4535412562123124", "Valaev Igor Sergeevich",
                1500, GetDate);




    }

}

