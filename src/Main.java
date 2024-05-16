


public class Main {

    public static void main(String[] args) {

        int availableCash = 7000;
        ATM atm1 = new ATM(availableCash);
        Frame frame = new Frame(atm1);

        frame.isVisible();

    }

}

