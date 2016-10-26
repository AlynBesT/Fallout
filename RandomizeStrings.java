import java.util.Random;
public class RandomizeStrings {
       private int level;
       private String[] breakCode = new String[5];
       private String currentString;
       public RandomizeStrings(int level) { // Constructor that keeps the level of difficulty.
             this.level = level;
       }
       public void selectString() {
            switch(level) { // Defining the strings from which we will randomly choose.
                case 1: {
                     breakCode[0] = "apple";
                     breakCode[1] = "cable";
                     breakCode[2] = "object";
                     breakCode[3] = "email";
                     breakCode[4] = "board";
                     break;
                }
                case 2: {
                     breakCode[0] = "elephant";
                     breakCode[1] = "student";
                     breakCode[2] = "computer";
                     breakCode[3] = "programmer";
                     breakCode[4] = "dinosaur";
                     break;
                }
                case 3: {
                     breakCode[0] = "psychoneuroendocrinological";
                     breakCode[1] = "immunoelectrophoretically ";
                     breakCode[2] = "thyroparathyroidectomized";
                     breakCode[3] = "pneumonoultramicroscopicsilicovolcanoconiosis";
                     breakCode[4] = "supercalifragilisticexpialidocious";
                     break;
                }
                default: {
                     break;
                }
            }
            Random rand = new Random(); 
            int value = rand.nextInt(5);
            currentString = breakCode[value]; 
       }
       public String getCorrectString() {
             return currentString;
       }
       private void showStrangeCharacters() { // This will basically show some random characters so that the output is harder to read.
            Random rand = new Random(); 
            int value;
            int currentStrangeCharacter;
            switch(level) {
                case 1: {
                     value = rand.nextInt(10)+2;
                     break;
                }
                case 2: {
                     value = rand.nextInt(12)+4;
                     break;
                }
                case 3: {
                     value = rand.nextInt(14)+6;
                     break;
                }
                default: {
                     value = 0;
                     break;
                }
            }
            for(int i=1;i<=value;i++) {
                  currentStrangeCharacter = rand.nextInt(7)+1;
                  if(currentStrangeCharacter == 1) System.out.print("/");
                  else if(currentStrangeCharacter == 2) System.out.print("*");
                  else if(currentStrangeCharacter == 3) System.out.print("^");
                  else if(currentStrangeCharacter == 4) System.out.print("$");
                  else if(currentStrangeCharacter == 5) System.out.print("@");
                  else if(currentStrangeCharacter == 6) System.out.print("#");
                  else if(currentStrangeCharacter == 7) System.out.print(";");
            }
       }
       public String shuffle(String inputString) { 
            char charString[] = inputString.toCharArray(); // Converting String to char so that we can work with the charachers.
            Random random = new Random();
            for( int i=0 ; i<charString.length-1 ; i++ ) {
                int j = random.nextInt(charString.length-1); // Swapping random places from the string.
                char temp = charString[i]; 
                charString[i] = charString[j];  
                charString[j] = temp;
            }       

         return new String(charString);
       }
       public void showStrings() {
             String shuffleString;
             shuffleString = currentString;
             for(int i=1;i<=level*3;i++) {
                        showStrangeCharacters(); 
                        shuffleString = shuffle(shuffleString);
                        System.out.print(shuffleString);
                        showStrangeCharacters();
                        System.out.println();
             }
       }
}
