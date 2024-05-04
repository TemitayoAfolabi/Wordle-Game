import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class wordleModel {
    private List<String> words;
    private String targetWord;
    private int maxAttempts;
    private int attempts;

    public wordleModel(int maxAttempts) {
        this.words = loadWordsFromFile("words.txt");
        this.targetWord = generateWord();
        this.maxAttempts = maxAttempts;
        this.attempts = 0;
    }

    private List<String> loadWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

    private String generateWord() {
        Random random = new Random();
        int index = random.nextInt(words.size());
        return words.get(index);
    }

    // Rest of the class remains the same
}
