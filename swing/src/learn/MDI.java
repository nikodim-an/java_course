/**
 * Многооконный интерфейс (MDI)
 *
 * @author : Хильченко А.Н
 * @project : swing
 * @date : 30.11.2021
 * @comments :
 */


package learn;
import javax.swing.*;

public class MDI extends JFrame{
    public MDI() {
        super("Многоконный интерфейс");
        setSize(700,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JDesktopPane desktop = new JDesktopPane();
        add(desktop);  // добавилось в центр
        JInternalFrame child1 = new JInternalFrame("Окно 1", true);
        JInternalFrame child2 = new JInternalFrame("Окно 2", true, true,true,true);
        JInternalFrame child3 = new JInternalFrame("Окно 3", true,false);   // смотреть конструкторы JInternalFrame
        child3.putClientProperty("JInternalFrame.isPalette",true);          // сделали окно - палитрой инструментов
        // добавляем дочерние окна на рабочий стол
        desktop.add(child1); child1.setBounds(80,100,200,100); child1.setVisible(true);
        desktop.add(child2); child2.setSize(200,60); child2.setVisible(true);
        desktop.add(child3); child3.setSize(100,200); child3.setVisible(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {public void run() { new MDI(); } });
    }
}
