public class ATM {

    private int availableCash;
    private int availableMaxDeposit;

    public void MakeDeposit(int cashAmount)
    {
        if (availableMaxDeposit >= cashAmount)
        {
            this.availableCash += cashAmount;
            System.out.println("Транзакция успешно введена!");
        }
        else
            System.out.println("Ошибка, превышен лимит депозита");
    }

    public void WithDrawCash(int cashAmount)
    {
        if (cashAmount <= this.availableCash)
        {
            this.availableCash -= cashAmount;
            System.out.println("Средства успешно выведены!");
        }
        else
            System.out.println("Ошибка, недостаточно средств для вывода!");
    }

    public void PutCard(){

    }

    public void ShowCash()
    {
        System.out.println(availableCash());
    }

    public int availableCash()
    {
        return availableCash;
    }





}
