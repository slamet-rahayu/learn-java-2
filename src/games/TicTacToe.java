package games;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TicTacToe {

    public static JFrame f = new JFrame();

    public static JButton btn = new JButton();
    public static JButton btn2 = new JButton();
    public static JButton btn3 = new JButton();
    public static JButton btn4 = new JButton();
    public static JButton btn5 = new JButton();
    public static JButton btn6 = new JButton();
    public static JButton btn7 = new JButton();
    public static JButton btn8 = new JButton();
    public static JButton btn9 = new JButton();

    public static ArrayList<Integer> selected = new ArrayList<>();
    public static ArrayList<Integer> available = new ArrayList<>();

    TicTacToe() {
        System.out.println("init");
    }

    public static void main(String[] args) {

    }

    public void initComponent() {
        btn.setBounds(10,10,100,100);
        btn2.setBounds(120,10,100,100);
        btn3.setBounds(230,10,100,100);
        btn4.setBounds(10,120,100,100);
        btn5.setBounds(120,120,100,100);
        btn6.setBounds(230,120,100,100);
        btn7.setBounds(10,230,100,100);
        btn8.setBounds(120,230,100,100);
        btn9.setBounds(230,230,100,100);

        btn.addActionListener(e -> onAction(1));
        btn2.addActionListener(e -> onAction(2));
        btn3.addActionListener(e -> onAction(3));
        btn4.addActionListener(e -> onAction(4));
        btn5.addActionListener(e -> onAction(5));
        btn6.addActionListener(e -> onAction(6));
        btn7.addActionListener(e -> onAction(7));
        btn8.addActionListener(e -> onAction(8));
        btn9.addActionListener(e -> onAction(9));

        f.add(btn);
        f.add(btn2);
        f.add(btn3);
        f.add(btn4);
        f.add(btn5);
        f.add(btn6);
        f.add(btn7);
        f.add(btn8);
        f.add(btn9);

        f.setSize(355, 400);
        f.setLayout(null);
        f.setTitle("Ticc Tacc Toes");
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void changeBtnBg(Integer num, Color color) {
        switch (num) {
            case 1 -> btn.setBackground(color);
            case 2 -> btn2.setBackground(color);
            case 3 -> btn3.setBackground(color);
            case 4 -> btn4.setBackground(color);
            case 5 -> btn5.setBackground(color);
            case 6 -> btn6.setBackground(color);
            case 7 -> btn7.setBackground(color);
            case 8 -> btn8.setBackground(color);
            case 9 -> btn9.setBackground(color);
        }
    }

    public void onAction(Integer num) {
        System.out.println(available);
        selected.add(num);
//        available.remove(num - 1);
        changeBtnBg(num, Color.red);
    }

    public static void selectRand() {

    }
}
