package dev.flgl.swissre;

/** Main class and commandline interface to the fortune calculator. */
public class Main {
  private static final String DEFAULT_FILE = "bobs_crypto.txt";

  public static void main(String[] args) {

    // Allow to give the input file as commandline parameter or fallback to default.
    String filepath;
    if (args.length == 0) {
      filepath = DEFAULT_FILE;
    } else {
      filepath = args[0];
    }

    BobsFortuneCalculator calculator = new BobsFortuneCalculator(filepath);
    calculator.run();
  }
}
