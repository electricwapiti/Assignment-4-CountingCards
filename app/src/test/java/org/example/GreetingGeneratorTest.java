package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GreetingGeneratorTest {
  // This is just an example test file to demonstrate how everything works
  // You should delete this file when you implement your own solution

  @Test
  void itSaysHello() {
    Shuffle generator = new Shuffle();
    assertEquals(generator.sayHello(), "Hello World!");
  }

  
}
