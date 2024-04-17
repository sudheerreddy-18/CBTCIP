import java.util.Random;
import java.util.Scanner;
public class NumberGuessQuest
{
    static Scanner sc = new Scanner(System.in);
    static int lowest = 1;
    static int highest= 100;
    static int total_rounds = 4;
    static int max_attempts = 7;
    private static void startGame()
    {
        Random random = new Random();
        int totalScore = 0;
        System.out.println("Welcome to the NumberGuessQuest!");
        System.out.println("You have " + total_rounds + " rounds to play.");

        for (int i = 1; i <= total_rounds; i++) {
            int targetNumber = random.nextInt(highest - lowest + 1) + lowest;
            int score = playRound(sc, random, targetNumber);
            totalScore += score;
            System.out.println("Round " + i + " Score is: " + score);
        }

        System.out.println("\nGame Over!");
        System.out.println("Total Score: " + totalScore);
        sc.close();
    }
    private static int playRound(Scanner sc, Random random, int targetNumber)
     {
        int attempts = 0;
        int score = 0;
        System.out.println("\nRound:");
        System.out.println("Guess the number between " + lowest + " and " + highest + ".");
        while (attempts < max_attempts)
         {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            attempts++;
            if (guess == targetNumber) {
                System.out.println("Congratulations! You guessed it right.");
                score = max_attempts - attempts + 1;
                break;
            } else if (guess < targetNumber) {
                System.out.println("Try a higher number.");
            } else {
                System.out.println("Try a lower number.");
            }
            if (attempts < max_attempts) {
                System.out.println("Attempts left: " + (max_attempts - attempts));
            }
        }
        if (attempts == max_attempts) {
            System.out.println("Sorry, you've run out of attempts. The correct number was: " + targetNumber);
        }
        return score;
    }
    public static void main(String[] args)
    {
        startGame();
    }
   
}

    
