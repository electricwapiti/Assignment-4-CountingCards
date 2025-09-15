package org.example;

public class App {
    public static void main(String[] args) {
        Shuffle generator = new Shuffle();
        int[] deck = generator.createDeck();
        int[] shuffled = Shuffle.naiveShuffler(deck);
        for (int card : shuffled) {
            System.out.print(card + " ");
        }
    }
}
