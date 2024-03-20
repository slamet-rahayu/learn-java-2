package games;

import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class Quizz {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Quizz quizz = new Quizz();
//        quizz.initComponent();
        quizz.testHttp();
    }

    private void initComponent() {
        JFrame frame = initMainFrame();
        JPanel sidePanel = sidePanel();
        JPanel mainPanel = mainPanel();
        frame.add(sidePanel);
        frame.add(mainPanel);
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

    private JPanel countDownPanel() {
        int intMinutes = 10;
        int intSeconds = 0;
        JPanel countDownPanel = new JPanel();
        countDownPanel.setBounds(25, 20, 200, 90);
        countDownPanel.setBackground(Color.white);
        countDownPanel.setLayout(null);
        countDownPanel.setVisible(true);
        JLabel minutesLabel = new JLabel(String.valueOf(intMinutes));
        minutesLabel.setFont(new Font("Serif", Font.PLAIN, 80));
        minutesLabel.setBounds(0, 0, 80, 80);
        JLabel secondsLabel = new JLabel("0"+ intSeconds);
        secondsLabel.setFont(new Font("Serif", Font.PLAIN, 80));
        secondsLabel.setBounds(100, 0, 80, 80);
        JLabel separator = new JLabel(":");
        separator.setFont(new Font("Serif", Font.PLAIN, 80));
        separator.setBounds(80, 0, 30, 70);
        countDownPanel.add(minutesLabel);
        countDownPanel.add(separator);
        countDownPanel.add(secondsLabel);
        return countDownPanel;
    }

    private JPanel shortCutPanel() {
        JPanel shortCutPanel = new JPanel();
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
        sidePanel.setVisible(true);
        return sidePanel;
    }

    private JPanel choicesButtonPanel() {
        JPanel buttonPanel = new JPanel();

        JButton choiceA = new JButton("lorem asdd asd as asd asd asd asd asd asd asd as asd as dasd as as ");
        JButton choiceB = new JButton("Ora umummmmqwqwd qwd qw qw dqwd qwd qw qwd qwd qwd qwd qwd qwd qwd");
        JButton choiceC = new JButton("Buadjingannnqw qwd qw qwd qwd qw dwqdasdq wd qwdqw");
        JButton choiceD = new JButton("Tempeeeeeeeeed q wdsad qwd sad qw qwd asd qw dsad asd  qw");

        buttonPanel.setBounds(0, 220, 510, 300);

        buttonPanel.add(choiceA);
        buttonPanel.add(choiceB);
        buttonPanel.add(choiceC);
        buttonPanel.add(choiceD);

        buttonPanel.setVisible(true);

        return buttonPanel;
    }



    private JPanel mainPanel() {
        JPanel mainPanel = new JPanel();
        JTextPane mainText = new JTextPane();
        JPanel choicesButtonPanel = choicesButtonPanel();

        mainPanel.setBounds(260, 0, 510, 600);
        mainPanel.setLayout(null);

        mainText.setText("Buah buah apa yang bisa main band?");
        mainText.setEnabled(false);
        mainText.setFont(new Font("Arial", Font.PLAIN, 14));
        mainText.setBounds(0, 0, 510, 200);

        mainPanel.add(mainText);
        mainPanel.add(choicesButtonPanel);
        mainPanel.setVisible(true);


        return mainPanel;
    }


    private void testHttp() {
        try {
            JSONParser parser = new JSONParser();
            HttpClient client = HttpClient.newHttpClient();
            URI uri = URI.create("https://jsonplaceholder.typicode.com/todos/1");
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Object obj = parser.parse(response.body());
            JSONObject jsObject = (JSONObject) obj;
            System.out.println(jsObject);
        } catch (ParseException | InterruptedException | IOException IE) {
            System.out.println(IE.getMessage());
        }
    }
}
