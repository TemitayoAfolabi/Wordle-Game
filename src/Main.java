public class Main {
    public static void main(String[] args) {
        int maxAttempts = 5;

        WordleModel model = new WordleModel(maxAttempts);
        WordleView view = new WordleView();
        WordleController controller = new WordleController(model, view);

        controller.playGame();
    }
}
