

public class ATM {

    private double availableCash;
    private double availableMaxDeposit;
    private PayCard card;

    public void MakeDeposit(int cashAmount)
    {
        if (availableMaxDeposit >= cashAmount)
        {
            this.card.Deposit(cashAmount);
            System.out.println("Транзакция успешно введена!");
        }
        else
            System.out.println("Ошибка, превышен лимит депозита");
    }

    public void WithDrawCash(int cashAmount)
    {
        if (cashAmount <= this.availableCash)
        {
            this.card.WithdrawCash(cashAmount);
            System.out.println("Средства успешно выведены!");
        }
        else
            System.out.println("Ошибка, недостаточно средств для вывода!");
    }


    public void InsertCard(PayCard card){
        this.card = card;
        this.availableMaxDeposit = this.card.getBalance() * 100;
    }

    public void ShowCardInfo(){
        System.out.println(
                "Владелец: " + card.getOwner() + "\n" +
                "Баланс: " + card.getBalance() + " руб \n" +
                "Дата получения: " +  card.getDateGet()
        );
    }

    public PayCard GetCard(PayCard card){
        return card;
    }

}
