//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Map;

class primbon_calculator extends JFrame {
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JComboBox<String> jComboBox;
    private JComboBox<String> jComboBox2;
    private JComboBox<String> jComboBox3;
    private JComboBox<String> jComboBox1;
    private final Map<String, Integer> dinaLair = Map.ofEntries(
            Map.entry("minggu", 5),
            Map.entry("senen", 4),
            Map.entry("selasa", 3),
            Map.entry("rebo", 7),
            Map.entry("kemis", 8),
            Map.entry("jemuwah", 6),
            Map.entry("setu", 9)
    );
    private final Map<String, Integer> dinaPasaran = Map.ofEntries(
            Map.entry("manis", 5),
            Map.entry("paing", 9),
            Map.entry("pon", 7),
            Map.entry("wage", 4),
            Map.entry("kliwon", 8)
    );
    private final Map<String, String> weton = Map.ofEntries(
            Map.entry("pegat", "Masalah yang sering ditemui oleh pasangan PEGAT ini di kemudian hari mulai dari " +
                    "masalah ekonomi, kekuasaan, perselingkuhan yang bisa menyebabkan pasangan tersebut bercerai atau pegatan."),
            Map.entry("ratu", "Bisa dibilang pasangan tersebut memang sudah jodohnya. Dihargai dan disegani oleh " +
                    "tetangga dan lingkungan sekitar. Saking harmonisnya, bahkan banyak orang yang iri akan keharmonisannya dalam membina rumah tangga."),
            Map.entry("jodoh", "Pasangan tersebut memang beneran cocok dan berjodoh. Pasangan ini bisa saling menerima " +
                    "segala kelebihan dan kekurangan masing-masing. Rumah tangga pasangan JODOH ini bisa rukun sampai tua."),
            Map.entry("topo", "Dalam membina rumah tangga, pasangan TOPO akan sering mengalami kesusahan di awal " +
                    "musim karena masih saling memahami tapi akan bahagia pada akhirnya. Masalah yang dihadapi bisa saja " +
                    "soal ekonomi dan lainnya. Nah, saat sudah memiliki anak dan cukup lama berumah tangga, akhirnya akan hidup sukses dan bahagia."),
            Map.entry("tinari", "Pasangan TINARI akan menemukan kebahagiaan. Dalam mencari rezeki diberikan " +
                    "kemudahan dan nggak sampai hidup kekurangan. Selain itu, hidupnya juga sering mendapat keberuntungan."),
            Map.entry("padu", "Dalam berumah tangga, pasangan PADU akan sering mengalami pertengkaran. Tapi Bela, " +
                    "meskipun sering bertengkar, nggak sampai cerai. Masalah pertengkaran tersebut bahkan bisa dipicu " +
                    "dari hal-hal yang sifatnya cukup sepele."),
            Map.entry("sujanan", "Dalam berumah tangga, pasangan SUJANAN akan sering mengalami pertengkaran dan masalah " +
                    "perselingkuhan. Bisa itu dari pihak laki-laki maupun perempuan yang memulai perselingkuhan tersebut."),
            Map.entry("pesthi", "Dalam berumah tangga, pasangan PESTHI akan rukun, tenteram, damai sampai tua. " +
                    "Meskipun ada masalah apapun nggak akan sampai merusak keharmonisan keluarga.")
    );

    primbon_calculator() {
        initComponent();
    }

    private void initComponent() {

        setTitle("Primbon Kalkulator!");
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final int jfWidth = getSize().width;
        final int jfHeight = getSize().height;

        JButton jButton = new JButton("Etung");
        JLabel jLabel = new JLabel("Primbon Kalkulator");
        JLabel jLabel1 = new JLabel("Jeneng Lanang");
        JLabel jLabel4 = new JLabel("Jeneng Wadon");
        JLabel jLabel2 = new JLabel("Dina Lair");
        JLabel jLabel5 = new JLabel("Dina Lair");
        JLabel jLabel3 = new JLabel("Dina Pasaran");
        JLabel jLabel6 = new JLabel("Dina Pasaran");
        jLabel7 = new JLabel("Neptu: ");
        jLabel8 = new JLabel("Weton: ");
        jLabel9 = new JLabel("");
        JTextField jTextField = new JTextField("");
        JTextField jTextField2 = new JTextField("");
        jComboBox = new JComboBox<>();
        jComboBox2 = new JComboBox<>();
        jComboBox3 = new JComboBox<>();
        jComboBox1 = new JComboBox<>();
        JSeparator sep = new JSeparator();


        for (String key : dinaLair.keySet()) {
            jComboBox.addItem(key);
            jComboBox2.addItem(key);
        }

        for (String key : dinaPasaran.keySet()) {
            jComboBox1.addItem(key);
            jComboBox3.addItem(key);
        }

        jButton.setBounds(150,jfHeight - 100,jfWidth - 300,30);

        jLabel.setBounds(10, 0, 200, 50);
        jLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));

        jLabel1.setBounds(10, 50, 200, 50);
        jLabel4.setBounds(250, 50, 200, 50);

        jLabel2.setBounds(10, 110, 200, 50);
        jLabel5.setBounds(250, 110, 200, 50);

        jLabel3.setBounds(10, 175, 200, 50);
        jLabel6.setBounds(250, 175, 200, 50);

        jTextField.setBounds(10, 85, 200, 30);
        jTextField2.setBounds(250, 85, 200, 30);

        jComboBox.setBounds(10, 145, 200, 30);
        jComboBox2.setBounds(250, 145, 200, 30);

        jComboBox1.setBounds(10, 210, 200, 30);
        jComboBox3.setBounds(250, 210, 200, 30);

        jLabel7.setBounds(10, 260, 200, 30);
        jLabel8.setBounds(10, 280, 200, 30);
        jLabel9.setBounds(10, 320, jfWidth - 100, 100);

        sep.setBounds(0, 260, jfWidth, 10);

        jButton.addActionListener(this::jButtonActionPerformed);

        jLabel7.setVisible(false);
        jLabel8.setVisible(false);
        jLabel9.setVisible(false);

        add(jButton);
        add(jLabel);
        add(jLabel1);
        add(jLabel4);
        add(jTextField);
        add(jTextField2);
        add(jLabel2);
        add(jComboBox);
        add(jComboBox1);
        add(jComboBox2);
        add(jComboBox3);
        add(jLabel3);
        add(jLabel5);
        add(jLabel6);
        add(jLabel7);
        add(jLabel8);
        add(jLabel9);
        add(sep);

    }

    private void jButtonActionPerformed(ActionEvent e) {
        String dinaLairL = (String) jComboBox.getSelectedItem();
        String dinaPasaranL = (String) jComboBox1.getSelectedItem();
        String dinaLairW = (String) jComboBox2.getSelectedItem();
        String dinaPasaranW = (String) jComboBox3.getSelectedItem();

        int dinaLairKeyL = dinaLair.get(dinaLairL);
        int dinaPasaranKeyL = dinaPasaran.get(dinaPasaranL);
        int dinaLairKeyW = dinaLair.get(dinaLairW);
        int dinaPasaranKeyW = dinaPasaran.get(dinaPasaranW);

        final int[] pegat = {1, 9, 10, 18, 19, 27, 28, 36};
        final int[] ratu = {2, 11, 20, 29};
        final int[] jodoh = {3, 12, 21, 30};
        final int[] topo = {4, 13, 22, 31};
        final int[] tinari = {5, 14, 23, 32};
        final int[] padu = {6, 15, 24, 33};
        final int[] sujanan = {6, 15, 24, 33};
        final int[] pesthi = {8, 17, 26, 35};

        jLabel7.setVisible(true);
        jLabel8.setVisible(true);
        jLabel9.setVisible(true);

        int wetonInt = dinaLairKeyL + dinaPasaranKeyL + dinaLairKeyW + dinaPasaranKeyW;
        jLabel7.setText(jLabel7.getText() + wetonInt);

        if (contains(pegat, wetonInt)) {
            jLabel8.setText(jLabel8.getText() + "PEGAT");
            jLabel9.setText(htmlTemplate(weton.get("pegat")));
        } else if (contains(ratu, wetonInt)) {
            jLabel8.setText(jLabel8.getText() + "RATU");
            jLabel9.setText(htmlTemplate(weton.get("ratu")));
        } else if (contains(jodoh, wetonInt)) {
            jLabel8.setText(jLabel8.getText() +"JODOH");
            jLabel9.setText(htmlTemplate(weton.get("jodoh")));
        } else if (contains(topo, wetonInt)) {
            jLabel8.setText(jLabel8.getText() + "TOPO");
            jLabel9.setText(htmlTemplate(weton.get("topo")));
        } else if (contains(tinari, wetonInt)) {
            jLabel8.setText(jLabel8.getText() + "TINARI");
            jLabel9.setText(htmlTemplate(weton.get("tinari")));
        } else if (contains(padu, wetonInt)) {
            jLabel8.setText(jLabel8.getText() + "PADU");
            jLabel9.setText(htmlTemplate(weton.get("padu")));
        } else if (contains(sujanan, wetonInt)) {
            jLabel8.setText(jLabel8.getText() + "SUJANAN");
            jLabel9.setText(htmlTemplate(weton.get("sujanan")));
        } else if (contains(pesthi, wetonInt)) {
            jLabel8.setText(jLabel8.getText() + "PESTHI");
            jLabel9.setText(htmlTemplate(weton.get("pesthi")));
        }

    }

    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    public static String htmlTemplate(String msg) {
        return "<html><body><p style='width: 300px'>"+msg+"</p><body></html>";
    }

    public static void main(String[] args) {
        new primbon_calculator().setVisible(true);
    }

}