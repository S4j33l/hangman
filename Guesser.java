package hangman;

import java.util.ArrayList;
import java.util.Scanner;

public class Guesser {
    private String guess;
    public void setGuess(String guess){
        this.guess = guess;
    }
    public String getGuess(){
        return guess;
    }
    public void makeAGuess(WordToGuess wToGuess){
        Scanner s = new Scanner(System.in);
        ArrayList<Character> guessStore = new ArrayList<>();
        while(true){
        System.out.println("Do you want to guess the whole word or a single letter in the word?");
        String wordOrLetterDecider = s.nextLine();
        if(wordOrLetterDecider.equalsIgnoreCase("WORD")){
            System.out.println("Try and guess the word!");
            String wordGuess = s.nextLine();
            if(wordGuess.equals(wToGuess.getGuessingWord())){
                System.out.println("You have guessed the word correctly! Congratulations!");
                break;
            }
            else{
                System.out.println("Your guess was incorrect! Keep trying.");
            }
        }
        else if(wordOrLetterDecider.equalsIgnoreCase("LETTER")){
            System.out.println("Please go ahead and guess a letter that is present in the word.");
            char letterGuess = s.nextLine().charAt(0);
            if(wordGuessUpdater(wToGuess, letterGuess, guessStore)) {
                System.out.println("The word has been guessed completely!");
                break;
            }
        }
        System.out.println("Do you want to keep guessing?");
        String guessContinuation = s.nextLine();
        if(guessContinuation.equalsIgnoreCase("YES")){
            continue;
        }
        else if(guessContinuation.equalsIgnoreCase("NO")){
            break;
        }
        s.close();
        }
    }
    private boolean wordGuessUpdater(WordToGuess wToGuess, char letterGuess, ArrayList<Character> guessStore){
        boolean completeGuess = false;
        if(wToGuess.getGuessingWord().contains(Character.toString(letterGuess))){
            System.out.println("Warra W. The letter that you guessed is present in the word.");
            completeGuess = true;
            for(int i=0;i<wToGuess.getGuessingWord().length();i++){
                if(wToGuess.getGuessingWord().charAt(i) == letterGuess){
                    System.out.print(letterGuess);
                    guessStore.add(letterGuess);
                }
                else if(guessStore.contains(wToGuess.getGuessingWord().charAt(i))) {
                    System.out.print(wToGuess.getGuessingWord().charAt(i));
                }
                else{
                    System.out.print("_");
                    completeGuess = false;
                }
            }
            System.out.println();
        }
        else {
            System.out.println("Unfortunately, the letter that you thought of is not present in the word. Please try again.");
            wToGuess.incorrectGuesses++;
            figureMaker(wToGuess);
        }
        return completeGuess;
    }
    private void figureMaker(WordToGuess wToGuess){
            switch(wToGuess.incorrectGuesses){
                case 1:
                    System.out.println("That's the first fumble. Watch out!");
                    System.out.println("    |***|   ");
                    System.out.println("    |___|   ");
                    break;
                case 2:
                    System.out.println("Another fumble. Keep your wits about you!");
                    System.out.println("    |***|   ");
                    System.out.println("    |___|   ");
                    System.out.println("      |     ");
                    System.out.println("      |     ");
                    break;
                case 3:
                    System.out.println("Strike Three! Half the figure has been made! Look out for yourself!");
                    System.out.println("    |***|   ");
                    System.out.println("    |___|   ");
                    System.out.println("      |  ---");
                    System.out.println("      |     ");
                case 4:
                    System.out.println("Not again. The upper body is already done!");
                    System.out.println("    |***|   ");
                    System.out.println("    |___|   ");
                    System.out.println(" ---  |  ---");
                    System.out.println("      |     ");
                    break;
                case 5:
                    System.out.println("This is your last chance. Don't mess it up!");
                    System.out.println("    |***|   ");
                    System.out.println("    |___|   ");
                    System.out.println(" ---  |  ---");
                    System.out.println("      |     ");
                    System.out.println("     /      ");
                    System.out.println("    /       ");
                    break;            
                case 6:
                    System.out.println("That's it! You failed to guess the word! Better luck next time.");
                    System.out.println("    |***|   ");
                    System.out.println("    |___|   ");
                    System.out.println(" ---  |  ---");
                    System.out.println("      |     ");
                    System.out.println("     / \\   ");
                    System.out.println("    /   \\  ");
                    break;
                default:
                    System.out.println("Bye");
                    break;
            }
        }
}