public class WordleController {
    private WordleModel model;
    private WordleView view;

    public WordleController(wordleModel model, wordleView view) {
        this.model = model;
        this.view = view;

        view.addSubmitListener(new SubmitListener());
    }

    public void playGame() {
        view.displayPrompt();
    }

    private class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String guess = view.getGuess();

            if (guess.equalsIgnoreCase(model.getTargetWord())) {
                view.displayCongratulations();
            } else {
                String feedback = model.generateFeedback(guess);
                view.displayFeedback(feedback);

                if (model.isGameOver()) {
                    view.displayGameOver(model.getTargetWord());
                } else {
                    view.displayPrompt();
                }
            }
        }
    }
}
