import javax.swing.*;
import java.awt.*;
/*
Это окно созданное на основе базового класса JFrame, и в нем есть визуальные элементы
Они расставлены при помощи компоновщика BorderLayout (который по сторонам света)
*/


class MyWindow1 extends JFrame{
    MyWindow1() {
        this.setTitle("Это просто окно");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(100, 100,400, 200);
        JLabel label = new JLabel("Это Label : и в нем есть текст");
        JButton button=new JButton("Кнопка");
        button.setToolTipText("Это подсказка дял кнопки");
        this.add(label, BorderLayout.NORTH);
        this.add(button, BorderLayout.SOUTH);

        this.setAlwaysOnTop(true);
        this.setVisible(true);
    }

}

public class FormWithWidgets {
    public static void main(String[] args) {
        new MyWindow1();
    }
}
