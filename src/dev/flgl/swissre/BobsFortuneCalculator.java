package dev.flgl.swissre;

import java.math.BigDecimal;
import java.util.List;

/**
 * Central class to calculate bob fortune. Reads the stockfile and calls the REST Service for each
 * position. Also does the output to the commandline.
 *
 * <p>Created by Florian Glanzner (florian.glanzner@gmail.com) on 12.09.2019.
 */
public class BobsFortuneCalculator {
  private static final String TARGET_SYMBOL = "EUR";
  private String filepath;

  /** Initialize the class with the path to bobs_crypte stock file. */
  public BobsFortuneCalculator(String filepath) {
    this.filepath = filepath;
  }

  public void run() {
    StockFileReader stockFileReader = new StockFileReader(filepath);
    List<StockItem> stockItems = stockFileReader.read();

    BigDecimal total = new BigDecimal("0");

    for (StockItem item : stockItems) {
      try {
        BigDecimal rate = resolveRate(item.getSymbol());
        BigDecimal value = item.getAmount().multiply(rate);
        total = total.add(value);
        System.out.println(String.format("%.2f %s", value, TARGET_SYMBOL));
      } catch (ResolveExchangeRateException ex) {
        // If the exchange rate could not be resolved for any reason we print the error but continue
        // the program for the other stocks.
        System.out.println(
            String.format("Could not resolve rate for %s: %s", item.getSymbol(), ex.getMessage()));
      }
    }
    System.out.println(String.format("Total: %.2f %s", total, TARGET_SYMBOL));
  }

  private BigDecimal resolveRate(String fromSymbol) {
    return CryptoCompareService.getExchangeRate(fromSymbol, TARGET_SYMBOL);
  }
}
