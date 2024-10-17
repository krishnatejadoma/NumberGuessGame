import java.util.*;
import java.util.concurrent.TimeUnit;

public class NumberGuessingGame {
    static  Scanner sc=new Scanner(System.in);

    public static void playGame(int numberToGuess, int maxTries){
        int numberOfTries = 0;
        int userGuess = 0;
        boolean hasGuessedCorrectly = false;

        while (!hasGuessedCorrectly && numberOfTries < maxTries) {
            System.out.print("Enter your guess: ");
            userGuess = sc.nextInt();  
            numberOfTries++;  

            try{
                TimeUnit.SECONDS.sleep(3);
            }catch(InterruptedException e){
            System.out.println(e.getLocalizedMessage());
            }

            if (userGuess == numberToGuess) {
                hasGuessedCorrectly = true;
                System.out.println("Congratulations! You've guessed the number " + numberToGuess + " correctly.");
                System.out.println("It took you " + numberOfTries + " tries.");
            }
            else if(Math.abs(userGuess-numberToGuess)<=2){
                if(numberOfTries == maxTries){
                    System.out.println("You are so close!");
                }
                else
                System.out.println("You are so close! Try again.");
            } 
            else if (userGuess < numberToGuess) {
                if(numberOfTries == maxTries){
                    System.out.println("Too low!");
                }
                else
                System.out.println("Too low! Try again.");
            } else {
                if(numberOfTries == maxTries){
                    System.out.println("Too high!");
                }
                else
                System.out.println("Too high! Try again.");
            }

            if (!hasGuessedCorrectly && numberOfTries < maxTries) {
                System.out.println("You have " + (maxTries - numberOfTries) + " tries left.");
            }
        }

        try{
            TimeUnit.SECONDS.sleep(3);
        }catch(InterruptedException e){
            System.out.println(e.getLocalizedMessage());
        }
        
        if (!hasGuessedCorrectly) {
            System.out.println("Sorry, you've used all " + maxTries + " tries. The correct number was " + numberToGuess + ".");
        }
    }

    public static void main(String args[]){
       
        System.out.println("Welcome to the Number Guessing Game!");

        try{
        TimeUnit.SECONDS.sleep(3);
        }catch(InterruptedException e){
            System.out.println(e.getLocalizedMessage());
        }
         System.out.println("I have chosen a number between 1 and 100. Try to guess it!");

         Random random = new Random();
         int numberToGuess = random.nextInt(100) + 1;

        try{
        TimeUnit.SECONDS.sleep(3);
        }catch(InterruptedException e){
            System.out.println(e.getLocalizedMessage());
        }

        int maxTries = 0;
        while (maxTries < 5 || maxTries > 10) {
            System.out.print("Enter the number of tries you want between 5 and 10: ");
            maxTries = sc.nextInt();
            if (maxTries < 5 || maxTries > 10) {
                System.out.println("Please enter a valid number between 5 and 10.");
            }
        }

        playGame(numberToGuess,maxTries);
    }
    
}
