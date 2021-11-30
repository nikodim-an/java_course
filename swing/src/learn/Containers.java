/**
 * Наименование класса
 *
 * @author : Хильченко А.Н
 * @project : swing
 * @date : 30.11.2021
 * @comments :
 */


package learn;
import javax.swing.*;
import java.awt.*;

public class Containers {

    static class PanelForm extends JFrame{
        public PanelForm(){
            setBounds(20,20,500,250);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            add(new JLabel("Закрытие этого окна приведет\n к закрытию приложения!"), BorderLayout.CENTER);
                // \n - не работает…
            // горизонтальная панель JPanel
            JPanel hPanel = new JPanel(); // горизонтальная ориентация — по умолчанию
            for (int i=1; i<10;i++){
                hPanel.add(new JButton("Горизонтально №"+(i+1)));
            }
            // вертикальная панель JPanel
            JPanel vPanel = new JPanel();
            vPanel.setLayout(new BoxLayout(vPanel, BoxLayout.Y_AXIS));
                // аналогично форме, так можно применить ЛЮБОЙ компоновщик.
            for (int i=1; i<10;i++){
                vPanel.add(new JButton("Вертикально №"+(i+1)));
            }
            // JToolBar
            JToolBar toolBar = new JToolBar();
            for (int i=1; i<10;i++){
                toolBar.add(new JButton("№"+(i+1)));
            }
            // JTabbedPane
            JTabbedPane tabPanel = new JTabbedPane(JTabbedPane.BOTTOM, JTabbedPane.SCROLL_TAB_LAYOUT);
            JPanel vTabPanel = new JPanel();
            vTabPanel.setLayout(new BoxLayout(vTabPanel, BoxLayout.Y_AXIS));
            for (int i=1; i<30;i++){
                vTabPanel.add(new JButton("Вертикально №"+(i+1)));
            }
            JPanel hTabPanel = new JPanel();
            for (int i=1; i<10;i++){
                hTabPanel.add(new JButton("Горизонтально №"+(i+1)));
            }
            tabPanel.addTab("Вертикально", vTabPanel);
            tabPanel.addTab("Горизонтально", hTabPanel);

            add(vPanel,BorderLayout.WEST);
            add(hPanel,BorderLayout.SOUTH);
            add(toolBar, BorderLayout.NORTH);
            add(tabPanel, BorderLayout.CENTER);
            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PanelForm();
    }
}
