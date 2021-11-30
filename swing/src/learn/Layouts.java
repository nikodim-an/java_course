/**
 * Swing - слои и добавление элементов
 *
 * @author : Хильченко А.Н
 * @project : swing
 * @date : 30.11.2021
 * @comments :
 */

package learn;

import javax.swing.*;
import java.awt.*;

public class Layouts {
    private static class BorderLayoutForm extends JFrame {
        public BorderLayoutForm(){
            setTitle("Border lauout (по временам света)");
            setBounds(20,20,500,250);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            // реализация наполнения
            JLabel label1 = new JLabel("Метка севера");
            JLabel label2 = new JLabel("Метка юга");
            JLabel label3 = new JLabel("Метка запада");
            JLabel label4 = new JLabel("Метка востока");
            JButton btt = new JButton("Кнопка \n по \n центру"); // \n не помогает
            //
            add(btt, BorderLayout.CENTER);
            add(label1, BorderLayout.NORTH);
            add(label2, BorderLayout.SOUTH);
            add(label3, BorderLayout.WEST);
            add(label4, BorderLayout.EAST);
            // в одной области может быть только один элемент (или контейнер с несколькими элементами)
            setVisible(true);
        }
    }

    private static class BoxLayoutForm extends JFrame {
        public BoxLayoutForm(){
            // добавляет в строку или столбец, без переноса, но его можно добавить в BorderLayout
            setTitle("Box lauout (строка/столбец)");
            setBounds(520,20,500,250);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS)); // или Y_AXIS
            for (int i = 1; i <= 10; i++) {
                add(new JButton("#" + i));
            }
            setVisible(true);
        }
    }

    private static class FlowLayoutForm extends JFrame {
        public FlowLayoutForm(){
            setTitle("Flow lauout (строка с переносом)");
            setBounds(20,270,500,250);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setLayout(new FlowLayout());
            for (int i = 1; i <= 42; i++) {
                add(new JButton("#" + i));
            }
            setVisible(true);
        }
    }

    private static class GridLayoutForm extends JFrame {
        public GridLayoutForm(){
            setTitle("Grid lauout (таблица)");
            // общее количество добавленных элементов делит поравну на ячейки и заполняет их
            // здесь интересно будет не комментировать а раскомментировать!
            setBounds(520,270,500,250);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setLayout(new GridLayout(3, 3));
            for (int i = 0; i < 3; i++) {
                // добавление идет по строкам
                add(new JLabel("Метка "+(i+1)));
                add(new JButton(String.valueOf(i + 1)));
                add(new JLabel("Коментарий "+(i+1)));
            }
            //add(new JLabel("Коментарий "));
            //add(new JLabel("Коментарий "));
            setVisible(true);
        }
    }

    private static class Form extends JFrame {
        public Form(){
            setTitle("Сложная форма - с комбинацией компоновщиков");
            setBounds(40,40,1000,500);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setVisible(true);
            add(new JLabel("При закрытии закроется все приложение!"), BorderLayout.CENTER);
        }
    }

    public static void main(String[] args) {
        new BorderLayoutForm();
        new BoxLayoutForm();
        new FlowLayoutForm();
        new GridLayoutForm();
        //new Form();
    }
}
