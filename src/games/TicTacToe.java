package games;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
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
    JButton btnRestart = new JButton();

    JPanel panel;
    JFrame frame;
    String winner = "";

    JLabel label = new JLabel();
    JLabel winnerLabel = new JLabel("Winner: ");

    ArrayList<Integer> selectedRed = new ArrayList<>();
    ArrayList<Integer> selectedBlue = new ArrayList<>();
    ArrayList<Integer> available = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));

    TicTacToe() {
    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.initComponent();
    }

    void initComponent() {
        frame = createFrame();
        panel = new JPanel();
        panel.setOpaque(false);
        panel.setBounds(0,0, 355, 400);

        btnRestart.setText("Restart");

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
        btnRestart.setBounds(230, 340, 100, 30);
        winnerLabel.setBounds(10, 340, 200, 40);
        winnerLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        btn.addActionListener(e -> onAction(1));
        btn2.addActionListener(e -> onAction(2));
        btn3.addActionListener(e -> onAction(3));
        btn4.addActionListener(e -> onAction(4));
        btn5.addActionListener(e -> onAction(5));
        btn6.addActionListener(e -> onAction(6));
        btn7.addActionListener(e -> onAction(7));
        btn8.addActionListener(e -> onAction(8));
        btn9.addActionListener(e -> onAction(9));
        btnRestart.addActionListener(e -> restart());
//
        panel.add(btn);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);
        panel.add(label);
        frame.add(btnRestart);
        frame.add(winnerLabel);
        panel.setVisible(true);
        frame.add(panel);

    }

    JFrame createFrame() {
        JFrame frame = new JFrame();
        frame.setSize(355, 430);
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
        if (!selectedRed.contains(num) && !selectedBlue.contains(num) && winner.isEmpty()) {
            selectedRed.add(num);
            changeBtnBg(num, Color.red);
            available.removeIf(integer -> integer.equals(num));
            boolean isWinnerRed = isWin(selectedRed);
            if (isWinnerRed) {
                winner = "Red";
                winnerLabel.setText("Winner: "+winner);
            } else {
                if (!available.isEmpty()) {
                    int rand = available.get(random.nextInt(available.size()));
                    while (selectedBlue.contains(rand)) {
                        rand = available.get(random.nextInt(available.size()));
                    }
                    selectedBlue.add(rand);
                    if (available.contains(rand)) {
                        available.remove((Integer) rand);
                    }
                    changeBtnBg(rand, Color.blue);
                    boolean isWinnerBlue = isWin(selectedBlue);
                    if (isWinnerBlue) {
                        winner = "Blue";
                        winnerLabel.setText("Winner: "+winner);
                    }
                }
            }
        }
    }

    boolean isWin(ArrayList<Integer> arrSelected) {
        int[][] winPattern = {
            {1,2,3},{4,5,6},{7,8,9},
            {1,4,7},{1,5,9},{7,5,3},
            {2,5,8},{3,6,9}
        };
        for(int[] win1: winPattern) {
            ArrayList<Integer> includes = new ArrayList<>();
            for (int win2: win1) {
                boolean isContain = arrSelected.contains(win2);
                if (isContain) {
                    includes.add(1);
                } else {
                    includes.add(0);
                }
            }
            if (!includes.contains(0)) {
                return true;
            }
        }
        return false;
    }

    void restart() {
        frame.getContentPane().repaint();
    }

}
