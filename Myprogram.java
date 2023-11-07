import java.util.Scanner;

public class MyProgram extends ConsoleProgram{
    private Hangman hangman;

    public void run() {
        setup();
        playGame();
        gameOver();
    }

    private void setup() {
        System.out.println("Welcome to Hangman!");
        hangman = new Hangman();
    }

private void playGame() {
    Scanner scanner = new Scanner(System.in);
    boolean gameWon = false; // Track if the game has been won
    while (!hangman.isGameOver()) {
        displayGameState();
        char guess = getPlayerGuess(scanner);
        hangman.acceptGuess(guess);
        
        if (hangman.isGameWon()) {
            gameWon = true;
            break;
        }
    }
    scanner.close();
    
    if (gameWon) {
        gameOver(); // Call gameOver() if the game is won
    }
}




    private void displayGameState() {
        System.out.println("Current state: " + hangman.getCurrentState());
        System.out.println("Guessed letters: " + hangman.getGuessedLetters());
        System.out.println("Attempts left: " + hangman.getAttemptsLeft());
        System.out.println();
    }

    private char getPlayerGuess(Scanner scanner) {
        while (true) {
            System.out.print("Enter your guess: ");
            String input = scanner.nextLine();
            if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
                return Character.toLowerCase(input.charAt(0));
            }
            System.out.println("Invalid input. Please enter a single letter.");
        }
    }

private void gameOver() {
    if (hangman.isGameWon()) {
        System.out.println("Congratulations, you won!");
    } 
    else {
        System.out.println("Game over! The word was: " + hangman.getSecretWord());
    }
    System.out.println("Thank you for playing Hangman!");
}


    public static void main(String[] args) {
        MyProgram game = new MyProgram();
        game.run();
    }
}
