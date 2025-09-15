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

  public static int[] naiveShuffler(int[] arr) {
    int n = arr.length;
    int[] copy = new int[n];
    int[] temp = arr.clone();
    Random rand = new Random();
    for(int k = 0; k < n; k++) {
      int i = rand.nextInt(n - k);
      copy[k] = temp[i];
      for(int j = 1; j < n - k - 1; j++){
        temp[j] = temp[j+1];
      }
    }
    return copy;
  }

  public static int[] secondShuffler(int[] arr) {
    Random rand = new Random();
    int m = arr.length;
    while (m > 0){
      int i = rand.nextInt(m);
      m--;
      int t = arr[m];
      arr[m] = arr[i];
      arr[i] = t;
    }

    return arr;
  }

  public static int[] fisherYatesShuffler(int[] arr) {
    int[] array = arr.clone();
    int m = array.length, t, i;
    Random rand = new Random();
    while (m > 0) {
      i = rand.nextInt(m);
      m--;
      t = array[m];
      array[m] = array[i];
      array[i] = t;
    }
    return array;
  }
}
