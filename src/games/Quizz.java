package games;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeSet;

public class Quizz {
    private int interval = 120;
    private Timer timer;
    private boolean success = false;
    private boolean loading = true;
    private String username = "";
    private String selectedCategory = "";
    private String selectedDifficulty = "";
    private JPanel welcomePanel;
    private JPanel mainQuizPanel;
    private JPanel sideQuizPanel;
    private final JComboBox<String> jCategory = new JComboBox<>();
    private final JComboBox<String> jDifficulty = new JComboBox<>();

    public Quizz() {
        String[] category = {
                "linux",
                "devops",
                "networking",
                "php",
                "javascript",
                "python",
                "html",
                "docker",
                "cloud",
                "kubernetes",
        };
        for (String s : category) {
            jCategory.addItem(s);
        }
        Map<String, String> difficulty = Map.ofEntries(
          Map.entry("ez😎", "easy"),
          Map.entry("mayan😁", "medium"),
          Map.entry("syulitt🥵", "hard")
        );
        for (String s : difficulty.keySet()) {
            jDifficulty.addItem(s);
        }
    }

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Quizz quizz = new Quizz();
        quizz.initComponent();
//        quizz.testHttp();
    }

    private void initComponent() {
        JFrame frame = initMainFrame();
        sideQuizPanel = sidePanel();
        mainQuizPanel = mainQuizPanel();
        welcomePanel = welcomePanel();

        JLabel quizTitle = new JLabel("Quiz PHP");
        quizTitle.setFont(new Font("Arial", Font.PLAIN, 18));
        quizTitle.setBounds(260, 0, 200, 40);

        frame.add(welcomePanel);
        frame.add(sideQuizPanel);
//        frame.add(quizTitle);
        frame.add(mainQuizPanel);

        frame.setVisible(true);
    }

    private JFrame initMainFrame() {
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Quizz Happy2");
        return frame;
    }

    private JPanel welcomePanel() {
        JPanel wPanel = new JPanel();
        JLabel wTitle = new JLabel("Selamat malam 😅");
        wTitle.setFont(new Font("Serif", Font.PLAIN, 20));
        wPanel.add(wTitle);

        JTextField inputUserName = new JTextField();
        JButton startButton = new JButton("Gasskeun>>");
        JLabel jCategoryLabel = new JLabel("Kategori");
        JLabel jDifficultyLabel = new JLabel("Kesyulitan");
        JLabel usernameLabel = new JLabel("Username");

        wTitle.setBounds(300, 50, 200, 40);
        jCategoryLabel.setBounds(340, 85, 100, 40);
        jDifficultyLabel.setBounds(340, 150, 100, 40);
        usernameLabel.setBounds(340, 215, 100, 40);
        jCategory.setBounds(320, 120, 100, 30);
        jDifficulty.setBounds(320, 185, 100, 30);
        inputUserName.setBounds(280, 250, 200, 30);
        startButton.setBounds(310, 300, 120, 30);

        startButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCategory = (String) jCategory.getSelectedItem();
                selectedDifficulty = (String) jDifficulty.getSelectedItem();
                username = inputUserName.getText();
                welcomePanel.setVisible(false);
                sideQuizPanel.setVisible(true);
                mainQuizPanel.setVisible(true);
            }
        });

        wPanel.add(jCategoryLabel);
        wPanel.add(jDifficultyLabel);
        wPanel.add(usernameLabel);
        wPanel.add(jCategory);
        wPanel.add(jDifficulty);
        wPanel.add(inputUserName);
        wPanel.add(startButton);

        wPanel.setBounds(0,0, 800, 400);
        wPanel.setVisible(true);
        wPanel.setLayout(null);

        return wPanel;
    }

    private JPanel countDownPanel() {
        JPanel countDownPanel = new JPanel();
        countDownPanel.setBounds(25, 20, 200, 90);
        countDownPanel.setBackground(Color.white);
        countDownPanel.setLayout(null);
        countDownPanel.setVisible(true);

        JLabel minutesLabel = new JLabel();
        minutesLabel.setFont(new Font("Serif", Font.PLAIN, 80));
        minutesLabel.setBounds(0, 0, 80, 80);
        JLabel secondsLabel = new JLabel();
        secondsLabel.setFont(new Font("Serif", Font.PLAIN, 80));
        secondsLabel.setBounds(100, 0, 80, 80);
        JLabel separator = new JLabel(":");
        separator.setFont(new Font("Serif", Font.PLAIN, 80));
        separator.setBounds(80, 0, 30, 70);

        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (interval < 1) {
                    timer.cancel();
                } else {
                    interval--;
                }
                String minutes = String.valueOf(Math.abs(interval/60));
                String seconds = String.valueOf(interval%60);
                minutesLabel.setText((minutes.length() < 2) ? "0"+minutes : minutes);
                secondsLabel.setText((seconds.length() < 2) ? "0"+seconds : seconds);
            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000);

        countDownPanel.add(minutesLabel);
        countDownPanel.add(separator);
        countDownPanel.add(secondsLabel);
        return countDownPanel;
    }

    private JPanel shortCutPanel() {
        JPanel shortCutPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btn10 = new JButton("10");

        shortCutPanel.add(btn1);
        shortCutPanel.add(btn2);
        shortCutPanel.add(btn3);
        shortCutPanel.add(btn4);
        shortCutPanel.add(btn5);
        shortCutPanel.add(btn6);
        shortCutPanel.add(btn7);
        shortCutPanel.add(btn8);
        shortCutPanel.add(btn9);
        shortCutPanel.add(btn10);

        shortCutPanel.setBackground(Color.white);
        shortCutPanel.setBounds(25, 130, 200, 300);
        shortCutPanel.setVisible(true);

        return shortCutPanel;
    }

    private JPanel sidePanel() {
        JPanel sidePanel = new JPanel();
        JPanel countDownPanel = countDownPanel();
        JPanel shortCutPanel = shortCutPanel();
        JButton finishButton = new JButton("Finish Him!");
        finishButton.setBounds(25, 450, 200, 30);
        sidePanel.setBounds(0, 0, 250, 600);
        sidePanel.setBackground(Color.lightGray);
        sidePanel.setLayout(null);
        sidePanel.add(countDownPanel);
        sidePanel.add(shortCutPanel);
        sidePanel.add(finishButton);
        sidePanel.setVisible(false);
        return sidePanel;
    }

    private JPanel choicesButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton choiceA = new JButton("Buah band?");
        JButton choiceB = new JButton("Buahahahaha wkek");
        JButton choiceC = new JButton("Buah lengkeng park");
        JButton choiceD = new JButton("Buah");

        buttonPanel.setBounds(0, 220, 510, 300);

        buttonPanel.add(choiceA);
        buttonPanel.add(choiceB);
        buttonPanel.add(choiceC);
        buttonPanel.add(choiceD);

        buttonPanel.setVisible(true);

        return buttonPanel;
    }

    private JPanel mainQuizPanel() {
        JPanel mainPanel = new JPanel();
        JLabel mainText = new JLabel();
        JPanel choicesButtonPanel = choicesButtonPanel();

        mainPanel.setBounds(260, 50, 510, 600);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.white);

        mainText.setText("Buah buah apa yang bisa main band?");
        mainText.setFont(new Font("Arial", Font.PLAIN, 14));
        mainText.setVerticalAlignment(JLabel.TOP);
        mainText.setBounds(10, 10, 510, 400);

        mainPanel.add(mainText);
        mainPanel.add(choicesButtonPanel);
        mainPanel.setVisible(false);

        return mainPanel;
    }


    private void testHttp() {
        try {
            JSONParser parser = new JSONParser();
            HttpClient client = HttpClient.newHttpClient();
            String api = "https://quizapi.io/api/v1/questions?apiKey=RhOPIqrl818g6q038R4UbLAErV2bX7EhYlqho81y&difficulty="+selectedDifficulty+"&limit=10&tags="+selectedCategory;
            URI uri = URI.create(api);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Object obj = parser.parse(response.body());
            JSONObject jsObject = (JSONObject) obj;
            System.out.println(response.body());
        } catch (ParseException | InterruptedException | IOException IE) {
            System.out.println(IE.getMessage());
            loading = false;
        }
    }
}
