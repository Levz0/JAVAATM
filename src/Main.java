import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {

    public static void main(String[] args) {

        String dateString = "15-12-2005";
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date cardDate = null;

        try {
            // Попытка разбора даты из строки
            cardDate = dateFormat.parse(dateString);
        } catch (ParseException e) {
            // Обработка исключения, если строка не может быть разобрана
            System.err.println("Ошибка парсинга даты: " + e.getMessage());
        }

        PayCard Card1 = new PayCard("4535412562123124", "Valaev Igor Sergeevich", 2000, cardDate);

        ATM atm1 = new ATM();
        Frame frame = new Frame(atm1);

        frame.isVisible();

    }

}

