package org.example;

import java.util.Random;

public class Shuffle {
  // This is just an example class to demonstrate how everything works
  // You should delete this file when you implement your own solution

  public String sayHello() {
    return "Hello World!";
  }

  public int[] createDeck() {
    int[] arr = new int[52];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = i;
    }
    return arr;
  }

  //TODO: Finish method
  public int[] naiveShuffle(int[] arr) {
    int n = arr.length;
    int[] result = new int[n];
    Random rand = new Random(23452);
    for (int k = 0; k < n; k++) {
      int i = rand.nextInt(n - k);
      result[k] = arr[i];
      // Remove element at index i by shifting left
      for (int j = i; j < n - k - 1; j++) {
        arr[j] = arr[j + 1];
      }
    }
    return result;
  }
}
