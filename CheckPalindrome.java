/* 
Name:Elizabeth Pursell
Date: 2/18/2022
CSE 007 Spring 2022: Lab 4
Produce CheckPalindrome program that will check a given string or integer to see if it is a palindrome
IDE Used: Visual Studio Code
*/
import java.util.Scanner;
public class CheckPalindrome {
    public static void main(String[] args){
        //create scanner and initiate variables
        Scanner myScan = new Scanner(System.in);
        char inputChar;
        String word = "";
        String fullWord;
        String modifiedWord = "";
        String junk = "";
        int userInput;
        int digit;
        int reverse = 0;
        int temp;
        boolean isPalindrome = true;
        boolean intCheck;
        boolean stringCheck = false;
        boolean check = false;

        //prompt for user input
        System.out.println("Enter your string or integer:");

        //check to see if the input is an integer
        intCheck = myScan.hasNextInt();

        //executes if the input is an integer
        if(intCheck){
            check = intCheck;
            //do while loop to ask for new integer until it is in range
            do{
                if(check){
                    userInput = myScan.nextInt();
                    stringCheck = false;
    
                    //checks to see if the integer is in range
                    if(userInput >= 11 && userInput <= 100000){
        
                        //while loop to reverse the input
                        temp = userInput;
                        while(temp != 0){
                            digit = temp % 10;
                            reverse = reverse * 10 + digit;
                            temp /= 10;
                        }
                        //if the reverse is the same as the input, it is a palindrome
                        if(reverse == userInput){
                            isPalindrome = true;
                            System.out.println("The int " + userInput + " is a palindrome.");
                            break;
                        }
                        //if the reverse is not the same as the input, it is not a palindrome
                        else{
                            isPalindrome = false;
                            System.out.println("The int " + userInput + " is not a palindrome.");
                            break;
                        }
                    }
                    //prints error if the input is out of range; asks for new input
                    else{
                        System.out.println("Invalid Input: Integer Out of Range");
                        intCheck = false;
                        System.out.println("Enter a new integer or string: ");
                        check = myScan.hasNextInt();
                    }
                }
                //if the new input after an invalid input is not an integer, go to the string loops
                else{
                    junk = myScan.nextLine();
                    stringCheck = true;
                    break;
                }
            }while(!intCheck);
        }
        else{
            stringCheck = true;
        }
        //executes if the input was not an integer; imports it as a string
        if (stringCheck){
            word = myScan.nextLine();

            //removes all the blank space in a string
            modifiedWord = word.replace(" ", "");

            //for loop to see if the first and last characters are the same as you go to the center of the string
            for(int i = 0; i < modifiedWord.length(); i++){
                
                //if they are not the same, it is not a palindrome
                if(modifiedWord.charAt(i) != modifiedWord.charAt(modifiedWord.length() - i - 1)){
                    isPalindrome = false;
                    System.out.println("The string " + word + " is not a palindrome.");
                    break;
                }
                //if they are the same, it is a palindrome
                else{
                    isPalindrome = true;
                }
            }
            if(isPalindrome){
                System.out.println("The string " + word + " is a palindrome.");
            }
        }
    }
}

