import java.util.*;
public class RandomNumber {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // generating a random
        Random random = new Random();
        int randomNumber = random.nextInt(100);

        int trials = 10;
        int guesses = 0;


        while (guesses < trials) {
            System.out.println("Enter number: ");
           if (scanner.hasNextInt()){ // Exception handling in case the user enters not a number
               int numberInput = scanner.nextInt();
               //comparing user input with random generated number
               if (numberInput == randomNumber) {
                   System.out.printf("Congratulations! %s", numberInput + " is the correct number.\n");
                   // checking if the user wants to play again
                   do{
                       System.out.println("Do you wish to continue playing? yes, no");
                       String userInput = scanner.next().toLowerCase();
                       if (!userInput.equals("yes")){
                           System.out.println("Thank you for playing, Goodbye");
                           break;
                       }
                       randomNumber = random.nextInt(100);
                       guesses = 0;
                   }while (true);

               } else if (numberInput < randomNumber) {
                   System.out.println("The number you entered is too low, try again");
               } else {
                   System.out.println("Number is too high");
                   guesses++;
                   if (guesses == trials) {
                       System.out.println("You have used up all your trials");
                       break;
                   }
               }
           }else {
               System.out.println("Please enter a valid input");
           }
        }
        scanner.close();
    }
}
