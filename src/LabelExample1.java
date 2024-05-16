import javax.swing.*;

public class LabelExample1 {
    public static void main(String[] args) {
        // Создаем новое окно
        JFrame frame = new JFrame("Пример метки");

        // Создаем новую метку
        JLabel label = new JLabel("Привет, мир!");

        // Добавляем метку в окно
        frame.add(label);

        // Устанавливаем размеры окна и делаем его видимым
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
