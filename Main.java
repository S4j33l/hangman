package hangman;

public class Main {
    public static void main(String...args){
      WordToGuess wtg = new WordToGuess();
      wtg.setGuessingWord("NIGGA");
      wtg.wordHider();
      Guesser Sajeel = new Guesser();
      Sajeel.makeAGuess(wtg);
      wtg.closeScanners();
    }
}
