import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalRounds = 0;
        int totalWins = 0;
        
        // Allow the user to play multiple rounds
        while (true) {
            // Play a round
            if (playRound(scanner)) {
                totalWins++;
            }
            totalRounds++;

            // Ask if the player wants to play again
            System.out.print("\nDo you want to play another round? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        
        // Display the score
        System.out.println("\nGame Over! You played " + totalRounds + " rounds and won " + totalWins + " times.");
        System.out.printf("Your win percentage is %.2f%%.\n", (double) totalWins / totalRounds * 100);
    }

    // Method to play a single round
    public static boolean playRound(Scanner scanner) {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1; // Generate a number between 1 and 100
        int attemptsLeft = 10; // Limit the user to 10 attempts
        System.out.println("Welcome to the Guessing Game!");
        System.out.println("I have chosen a number between 1 and 100.");

        // Prompt the user to guess and provide feedback
        while (attemptsLeft > 0) {
            System.out.println("\nYou have " + attemptsLeft + " attempts remaining.");
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (guess == numberToGuess) {
                System.out.println("Congratulations! You've guessed the correct number!");
                return true; // Player won this round
            } else if (guess < numberToGuess) {
                System.out.println("Your guess is too low.");
            } else {
                System.out.println("Your guess is too high.");
            }

            attemptsLeft--;
        }

        System.out.println("\nSorry, you've run out of attempts. The correct number was " + numberToGuess + ".");
        return false; // Player lost this round
    }
}
