import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import java.util.logging.*;

public class tempconverter extends JFrame {

    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JCheckBox jCheckBox2;
    private JComboBox<String> jComboBox1;
    private JComboBox<String> jComboBox2;
    private JLabel jLabel1;
    private JPanel jPanel2;
    private JTextField jTextField1;
    private JTextField jTextField2;


    public tempconverter() {
        initComponents();
    }

    private void initComponents() {
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jCheckBox2 = new JCheckBox();
        jComboBox1 = new JComboBox<>();
        jComboBox2 = new JComboBox<>();
        jTextField1 = new JTextField();
        jTextField2 = new JTextField();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();

        jCheckBox2.setText("jCheckbox2");

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setTitle("Temperature Converter");

        jPanel2.setBackground(new Color(51, 51, 51));
        jLabel1.setBackground(new Color(51, 51, 51));
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD,24));
        jLabel1.setForeground(new Color(255, 255, 255));
        jLabel1.setText("Temperature Converter");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);

        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel1)
                        .addContainerGap(161, Short.MAX_VALUE)
                )
        );

        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addContainerGap(23, Short.MAX_VALUE)
                )
        );

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] {"Celsius", "Fahrenheit"}));
        jComboBox2.setModel(new DefaultComboBoxModel<>(new String[] {"Celsius", "Fahrenheit"}));

        jTextField2.setEditable(false);

        jButton1.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
        jButton1.setText("Convert");
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton1ActionPerformed(e);
            }
        });

        jButton2.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
        jButton2.setText("Clear");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton2ActionPerformed(e);
            }
        });

        jButton3.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
        jButton3.setText("Exit");
        jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButton3ActionPerformed(e);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(
                        layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jComboBox2, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jComboBox1, 0, 116, Short.MAX_VALUE)
                        )
                        .addGap(133, 133, 133)
                        .addGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)

                        )
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                )
                .addGroup(
                        GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(jButton3)
                                .addComponent(jButton2)
                        )
                        .addGap(29, 29, 29)
                )
                .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        )
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(jButton2)
                        )
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                        )
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(37, 37, 37)
                )
        );

        pack();

    }

    private void jButton3ActionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private void jButton2ActionPerformed(ActionEvent e) {
        jTextField1.setText("");
        jTextField2.setText("");
    }

    private void jButton1ActionPerformed(ActionEvent e) {
        String val1 = (String) jComboBox1.getSelectedItem();
        String val2 = (String) jComboBox2.getSelectedItem();

        if (Objects.equals(val1, "Celsius") && Objects.equals(val2, "Fahrenheit")) {
            double cel = Double.parseDouble(jTextField1.getText());
            double fah = (double) ((9.0/5.0)*cel +32);
            jTextField2.setText(String.valueOf(fah));
        } else if (Objects.equals(val1, "Celsius") && Objects.equals(val2, "Celsius")) {
            double c = Double.parseDouble(jTextField1.getText());
            jTextField2.setText(String.valueOf(c));
        }
        if (Objects.equals(val1, "Fahrenheit") && Objects.equals(val2, "Celsius")) {
            double f = Double.parseDouble(jTextField1.getText());
            double c = (double)((f-32)*(5.0/9.0));
            jTextField2.setText(String.valueOf(Math.round(c)));
        } else if (Objects.equals(val1, "Fahrenheit") && Objects.equals(val2, "Fahrenheit")) {
            double f = Double.parseDouble(jTextField1.getText());
            jTextField2.setText(String.valueOf(Math.round(f)));
        }
    }

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(tempconverter.class.getName()).log(Level.SEVERE, null, ex);
        }

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new tempconverter().setVisible(true);
            }
        });
    }
}
