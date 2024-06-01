import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CardFrame extends JFrame {

    private JTextField numberField;
    private JTextField ownerField;
    private JTextField balanceField;
    private JTextField dateGetField;

    public CardFrame() {
        ImageIcon icon = new ImageIcon("src/resources/CardIcon.png");
        Image image = icon.getImage();
        setIconImage(image);
        setTitle("Добавить карту");
        setSize(1000, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowStateChanged(WindowEvent e) {
                // Если окно пытаются максимизировать, восстанавливаем его размер
                if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {
                    setExtendedState(JFrame.NORMAL);
                }
            }
        });
        Font largeFont = new Font("Arial", Font.PLAIN, 18);

        JPanel panel = new JPanel(new GridLayout(5, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Card Number:"));
        numberField = new JTextField();
        numberField.setFont(largeFont);
        panel.add(numberField);

        panel.add(new JLabel("Owner:"));
        ownerField = new JTextField();
        ownerField.setFont(largeFont);
        panel.add(ownerField);

        panel.add(new JLabel("Balance:"));
        balanceField = new JTextField();
        balanceField.setFont(largeFont);
        panel.add(balanceField);

        panel.add(new JLabel("Date Get (dd.MM.yyyy):"));
        dateGetField = new JTextField();
        dateGetField.setFont(largeFont);
        panel.add(dateGetField);

        JButton addButton = new JButton("Add Card");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardEntered();
            }
        });
        panel.add(addButton);

        add(panel);
        setVisible(true);
    }

    public void CardEntered(){
        String Number = numberField.getText();
        String Owner = ownerField.getText();
        double Balance;
        try {
            Balance = Double.parseDouble(balanceField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid balance format", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String DataGet = dateGetField.getText();;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate FormatedDataGet = LocalDate.parse(DataGet, formatter);


        ATM atm1 = new ATM();
        ATMFrame atmFrame = new ATMFrame(atm1);
        PayCard card = new PayCard(Number, Owner, Balance, FormatedDataGet);

        atm1.InsertCard(card);
        atmFrame.isVisible();

    }


}
