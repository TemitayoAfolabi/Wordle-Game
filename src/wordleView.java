import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordleView extends JFrame {
    private JLabel promptLabel;
    private JTextField guessField;
    private JButton submitButton;
    private JTextArea feedbackArea;

    public WordleView() {
        setTitle("Wordle Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        promptLabel = new JLabel("Enter your guess: ");
        guessField = new JTextField(20);
        submitButton = new JButton("Submit");
        topPanel.add(promptLabel);
        topPanel.add(guessField);
        topPanel.add(submitButton);
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        feedbackArea = new JTextArea(10, 30);
        feedbackArea.setEditable(false);
        centerPanel.add(feedbackArea);
        add(centerPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public String getGuess() {
        return guessField.getText();
    }

    public void displayFeedback(String feedback) {
        feedbackArea.append(feedback + "\n");
    }

    public void displayCongratulations() {
        JOptionPane.showMessageDialog(this, "Congratulations! You guessed the word correctly.");
    }

    public void displayGameOver(String targetWord) {
        JOptionPane.showMessageDialog(this, "Game over! You couldn't guess the word. The word was: " + targetWord);
    }

    public void addSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }
}
