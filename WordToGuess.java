package hangman;

import java.util.Scanner;

public class WordToGuess {
    private String guessingWord;
    public int incorrectGuesses;
    public void setGuessingWord(String guessingWord) {
        this.guessingWord = guessingWord;
    }
    public String getGuessingWord() {
        return guessingWord;
    }
    Scanner s = new Scanner(System.in);
    public void wordHider(){
        String obscuredWordToBeGuessed = "";
        System.out.println("Please enter the word that you want the guesser to guess: ");
        String wordToBeGuessed  = s.nextLine();
        System.out.println("The word that is to be guessed is: ");
        for(int i=0;i<wordToBeGuessed.length();i++){
            obscuredWordToBeGuessed += "_";
        }        
        System.out.println(obscuredWordToBeGuessed);
    }
    public void closeScanners(){
        if(s != null){
            s.close();
        }
    }
}
