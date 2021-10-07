import javax.swing.*;
/*
Это окно созданное на основе базового класса JFrame, и в нем ничего нет
*/


class MyWindow extends JFrame{
    MyWindow() {
        this.setTitle("Это просто окно");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 1240, 700);
        this.setVisible(true);
    }

}

public class SymplyForm {
    public static void main(String[] args) {
        new MyWindow();
    }
}
