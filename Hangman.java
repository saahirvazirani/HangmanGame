public class Hangman {
    private String secretWord;
    private String currentState;
    private int attemptsLeft;
    private String guessedLetters;

    public Hangman() {
        secretWord = "saahir"; // Set the secret word
        currentState = "_ _ _ _ _ _ _"; // Initialize the current state of the word being guessed
        attemptsLeft = 6; // Set the number of attempts
        guessedLetters = ""; // Initialize the guessed letters
    }

public boolean isGameOver() {
    return attemptsLeft <= 0 || isGameWon(); // Game over if no attempts left or the game is won
}


    public String getCurrentState() {
        return currentState;
    }

    public String getGuessedLetters() {
        return guessedLetters;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

public void acceptGuess(char guess) {
    if (guessedLetters.contains(String.valueOf(guess))) {
        return; // Skip processing if the letter has already been guessed
    }
    guessedLetters += guess; // Add the guessed letter to the list of guessed letters
    if (secretWord.contains(String.valueOf(guess))) {
        updateCurrentState(guess); // Update the current state if the guess is correct
    } else {
        attemptsLeft--; // Reduce the attempts if the guess is incorrect
    }
}


    private void updateCurrentState(char guess) {
        StringBuilder builder = new StringBuilder(currentState);
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == guess) {
                builder.setCharAt(i * 2, guess); // Update the current state with the correctly guessed letter
            }
        }
        currentState = builder.toString();
    }

public boolean isGameWon() {
    String currentStateWithoutSpaces = currentState.replace(" ", "").replace("_", "");
    return currentStateWithoutSpaces.equals(secretWord);
}


    public String getSecretWord() {
        return secretWord;
    }
}
