import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        char playAgain;

        System.out.println("=================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("=================================");

        do {

            int randomNumber = random.nextInt(100) + 1;
            int maxAttempts = 5;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");
                int userGuess = sc.nextInt();

                attempts++;

                if (userGuess == randomNumber) {

                    System.out.println("🎉 Congratulations!");
                    System.out.println("You guessed the correct number.");

                    int score = (maxAttempts - attempts + 1) * 10;
                    totalScore += score;

                    System.out.println("Score earned: " + score);

                    guessedCorrectly = true;
                    break;
                }

                else if (userGuess < randomNumber) {
                    System.out.println("Too Low! Try a bigger number.");
                }

                else {
                    System.out.println("Too High! Try a smaller number.");
                }

                System.out.println("Attempts Left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("\n❌ Game Over!");
                System.out.println("The correct number was: " + randomNumber);
            }

            System.out.println("\nCurrent Total Score: " + totalScore);

            System.out.print("\nDo you want to play again? (Y/N): ");
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'Y' || playAgain == 'y');

        System.out.println("\n=================================");
        System.out.println("GAME ENDED");
        System.out.println("Final Score: " + totalScore);
        System.out.println("Thank You For Playing!");
        System.out.println("=================================");

        sc.close();
    }
}  