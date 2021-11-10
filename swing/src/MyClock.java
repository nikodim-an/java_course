/**
 * Наименование класса
 *
 * @author : Хильченко А.Н
 * @version : номер, дата
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

class C_Label extends JLabel implements ActionListener{
    private SimpleDateFormat sdf;

    public C_Label(){
        this.sdf = new SimpleDateFormat("hh:mm ss");
        this.setHorizontalAlignment(SwingConstants.CENTER);
        Timer t = new Timer(1000, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae) {
        Date d = new Date();
        setText(sdf.format(d));
    }
}


public class MyClock extends JFrame {
    public static void main(String[] args) {
        JFrame form = new JFrame("Digital Clock"); // создание формы с заголовком
        form.setUndecorated(true);  // отключил заголовок и рамку
        form.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        form.setBounds(100,100,70,16);
        C_Label label = new C_Label();
        form.add(label, BorderLayout.NORTH);
        form.setAlwaysOnTop(true);
        form.setVisible(true);
    }

}
