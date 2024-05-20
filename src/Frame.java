
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Frame extends JFrame {
    
    private ATM atm;

    JLabel cashLabel;

    public Frame(ATM atm) {
        this.atm = atm;
        setTitle("Банкомат");
        ImageIcon icon = new ImageIcon("src/resources/ATM.png");
        Image image = icon.getImage();
        setIconImage(image);
        setSize(1000, 500); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); 

        // Добавляем слушатель событий окна
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowStateChanged(WindowEvent e) {
            // Если окно пытаются максимизировать, восстанавливаем его размер
            if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {
                setExtendedState(JFrame.NORMAL);
            }
            }
        });


        cashLabel = new JLabel("0");
        cashLabel.setForeground(Color.BLACK); // Устанавливаем цвет текста

        MainATM mainATM = new MainATM(this, this.getContentPane());

        // Создаем панель для размещения метки и кнопок
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        LabelChooseTheAction(mainPanel); // Добавляем метку на панель
        Buttons(mainPanel); // Добавляем кнопки на панель



        // Добавление терминальной панели на JFrame

        // Добавляем основную панель на фрейм
        add(mainPanel);
        setVisible(true); // делаем окно видимым

       
        setResizable(false);
    }

    public void LabelChooseTheAction(JPanel mainPanel) {
        JLabel chooseTheAction = new JLabel("Выберите действие", SwingConstants.CENTER);
        chooseTheAction.setFont(new Font("Arial", Font.BOLD, 20));

        // Добавляем метку в северную часть панели
        mainPanel.add(chooseTheAction, BorderLayout.NORTH);
    }
    
    public void Buttons(JPanel mainPanel) {
        JButton buttonDeposit = new JButton("Сделать депозит");
        JButton buttonWithDraw = new JButton("Снять средства");
        JButton buttonShowCash = new JButton("Показать баланс");

        // Создаем панель для размещения кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Выравнивание кнопок по центру

        // Добавляем кнопки на панель
        buttonPanel.add(buttonDeposit);
        buttonPanel.add(buttonWithDraw);
        buttonPanel.add(buttonShowCash);

        // Добавляем панель с кнопками в центральную часть панели
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Присваиваем кнопкам команды с помощью ActionListener
        buttonDeposit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ваш код для действия по нажатию кнопки "Сделать депозит"
                // Например, открытие формы для внесения депозита
                String userInput = JOptionPane.showInputDialog(Frame.this, "Введите сумму:", "Депозит", JOptionPane.PLAIN_MESSAGE);

                if (userInput != null) {
                    try {
                        int cash = Integer.parseInt(userInput);
                        GetAtm().MakeDeposit(cash);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(Frame.this, "Ошибка! Введите корректное число.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else {
                    JOptionPane.showMessageDialog(Frame.this, "Операция отменена.", "Отмена", JOptionPane.INFORMATION_MESSAGE);
                }

            }
        });

        buttonWithDraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userInput = JOptionPane.showInputDialog( Frame.this, "Введите сумму:", "Вывод средств", JOptionPane.PLAIN_MESSAGE);

                try {
                    int cash = Integer.parseInt(userInput);
                    GetAtm().WithDrawCash(cash);
                }
                catch(NumberFormatException ex) {

                    JOptionPane.showMessageDialog(Frame.this, "Ошибка! Введите корректное число.", "Ошибка", JOptionPane.ERROR_MESSAGE);

                }


            }
        });


        buttonShowCash.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GetAtm().ShowCash();
                cashLabel.setText(String.valueOf(GetAtm().availableCash()));

            }
        });
    }

    public ATM GetAtm()
    {
        return this.atm;
    }



}

class MainATM
{
    private Image imgATM;

    public MainATM(Frame frame, Container container) {

        JLabel imageLabel = new JLabel(new ImageIcon(new ImageIcon("src/resources/Bankomat.png").getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
        imageLabel.setPreferredSize(new Dimension(300, 200));
        container.setLayout(new BorderLayout());

        container.add(imageLabel, BorderLayout.WEST);


    }




}
