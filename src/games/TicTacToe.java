package games;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class TicTacToe {

    JButton btn = new JButton();
    JButton btn2 = new JButton();
    JButton btn3 = new JButton();
    JButton btn4 = new JButton();
    JButton btn5 = new JButton();
    JButton btn6 = new JButton();
    JButton btn7 = new JButton();
    JButton btn8 = new JButton();
    JButton btn9 = new JButton();

    JLabel label = new JLabel();

    ArrayList<Integer> selected = new ArrayList<>();
    ArrayList<Integer> available = new ArrayList<>();
    int[][] winPattern = {{}};

    TicTacToe() {
        for (int i = 0; i < 9; i++) {
            available.add(i+1);
        }
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.initComponent();
    }

    void initComponent() {
        JFrame frame = createFrame();

        btn.setBounds(10,10,100,100);
        btn2.setBounds(120,10,100,100);
        btn3.setBounds(230,10,100,100);
        btn4.setBounds(10,120,100,100);
        btn5.setBounds(120,120,100,100);
        btn6.setBounds(230,120,100,100);
        btn7.setBounds(10,230,100,100);
        btn8.setBounds(120,230,100,100);
        btn9.setBounds(230,230,100,100);
        label.setBounds(120, 120, 200, 40);

        btn.addActionListener(e -> onAction(1));
        btn2.addActionListener(e -> onAction(2));
        btn3.addActionListener(e -> onAction(3));
        btn4.addActionListener(e -> onAction(4));
        btn5.addActionListener(e -> onAction(5));
        btn6.addActionListener(e -> onAction(6));
        btn7.addActionListener(e -> onAction(7));
        btn8.addActionListener(e -> onAction(8));
        btn9.addActionListener(e -> onAction(9));

        frame.add(btn);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);
        frame.add(btn6);
        frame.add(btn7);
        frame.add(btn8);
        frame.add(btn9);
        frame.add(label);

        JButton showPopup = new JButton("Show Popup");
        showPopup.setBounds(12, 12, 100, 20);

        JPanel popupPanel = createPopupPanel();
        popupPanel.setBounds(120, 120, 100, 100);

        showPopup.addActionListener(e -> popupPanel.setVisible(true));

    }

    JPanel createPopupPanel() {
        JPanel popupPanel = new JPanel(new BorderLayout());
        popupPanel.setOpaque(false);
        popupPanel.setMaximumSize(new Dimension(150, 70));
        popupPanel.setBorder(new LineBorder(Color.gray));
        popupPanel.setVisible(false);

        JLabel popupLabel = new JLabel("Hello Bozo");
        popupPanel.add(wrapInPanel(popupLabel));

        JButton popupCloseButton = new JButton("Close");
        popupPanel.add(wrapInPanel(popupCloseButton), BorderLayout.SOUTH);

        popupCloseButton.addActionListener(e -> popupPanel.setVisible(false));

        return popupPanel;

    }

    JPanel wrapInPanel(JComponent component) {
        JPanel panel = new JPanel();
        panel.setBackground(new Color(50, 210, 250, 150));
        panel.add(component);
        return panel;
    }

    JFrame createFrame() {
        JFrame frame = new JFrame();
        frame.setSize(355, 400);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Ticc Tacc Toes");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        return frame;
    }

    void changeBtnBg(Integer num, Color color) {
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

    void onAction(Integer num) {
        Random random = new Random();
        if (!selected.contains(num)) {
            selected.add(num);
            changeBtnBg(num, Color.red);
            available.removeIf(integer -> integer.equals(num));
//            if (available.size() > 0) {
//                int rand = available.get(random.nextInt(available.size()));
//                selected.add(rand);
//                available.removeIf(integer -> integer.equals(rand));
//                changeBtnBg(rand, Color.blue);
//            }
        }
    }

}
