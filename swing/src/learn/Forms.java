/**
 * Swing - формы и работа с ними
 *
 * @author : Хильченко А.Н
 * @project : swing
 * @date : 30.11.2021
 * @comments :
 */


package learn;

import javax.swing.*;

public class Forms {

    static class myForm extends JFrame {
        public myForm(){
            setBounds(10,10,300,70);
            setTitle("Заголовок второго окна");
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            // … код реализации
            setVisible(true);
        }

    }

    static void simpleForm(){
        // Минимальнй код формы
        JFrame form = new JFrame("Заголовок окна");
        form.setBounds(100,100,500,250);
        form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // … код реализации формы
        form.setVisible(true);
    }

    public static void main(String[] args) {
        simpleForm();               // минимальный код формы «на лету»
        myForm form = new myForm(); // более правильная реализация формы
    }

}
