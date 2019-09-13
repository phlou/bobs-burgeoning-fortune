package dev.flgl.swissre;

import org.junit.Test;

/** Created by Florian Glanzner (florian.glanzner@gmail.com) on 13.09.2019. */
public class BobsFortuneCalculatorTest {

  @Test
  public void run() {
    BobsFortuneCalculator calculator = new BobsFortuneCalculator("test_fixtures_bad.txt");
    calculator.run();
    // Not much to assert here.
  }
}
