import java.util.Scanner;
public class Fallout {
     public static void CloseProgram(int closeCode) { // method that closes the program if you don't get the correct password / you don't select good options on menu
            if(closeCode == 1) System.out.println("You have selected an invalid option. This session was terminated.");
            else if(closeCode == 2) System.out.println("You didn't find the correct password this time. This session was terminated.");
            System.exit(0);
     }
     public static void main(String[] args) {
            char isPlaying;
            int difficultyLevel;
            int tries;
            String getString;
            Scanner scan = new Scanner(System.in);
            System.out.println("Welcome to Fallout Hacking! Would you like to play? [Y/N]");
            isPlaying = scan.next().charAt(0); // getting a single character, continuing only if it is 'Y'
            while(isPlaying == 'Y') {
                   System.out.println("Please select your level of difficulty: [1/2/3(don't even try)]");
                   difficultyLevel = scan.nextInt();
                   if(difficultyLevel < 1 || difficultyLevel > 3)
                           CloseProgram(1); // Making sure that the program doesn't have invalid menu items
                   tries = 3; // Reinitalising the game
                   System.out.println("You have 3 chances to guess the string of the following list:");
                   RandomizeStrings hackCode = new RandomizeStrings(difficultyLevel);
                   hackCode.selectString(); 
                   hackCode.showStrings();
                   getString = scan.nextLine();
                   System.out.println("[" + tries + "/3] Please enter your string: ");
                   getString = scan.nextLine();
                   while(!getString.equals(hackCode.getCorrectString())) { // Trying to get the good word, by putting the user to retype.
                      tries--;
                      if(tries == 0) {
                            System.out.println("The word you didn't guess was '" + hackCode.getCorrectString() + "'. Good luck next time!");
                            CloseProgram(2);
                      }
                      System.out.println("[" + tries + "/3] Please enter your string: ");
                      getString = scan.nextLine();
                   }
                   System.out.print("Congratulations! You have found the word '" + hackCode.getCorrectString() + "', remaining with " + tries + " tries! "); // Some motivational speech.
                   if(tries == 3) System.out.print("You are the best hacker ever seen!");
                   else if(tries == 2) System.out.print("You are a good hacker!");
                   else if(tries == 1) System.out.print("You are a hacker!");
                   System.out.println();
                   System.out.println("Would you still like to play? [Y/N]"); // Continuing in the loop, so that the game can never end.
                   isPlaying = scan.next().charAt(0);
            }
            CloseProgram(1); // If the character is not 'Y', we close the program.
     }
}
