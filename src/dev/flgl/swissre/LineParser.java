package dev.flgl.swissre;

import java.math.BigDecimal;

/**
 * Parser for a single line of the data file. Parses a line to a StockItem. Created by Florian
 * Glanzner (florian.glanzner@gmail.com) on 12.09.2019.
 */
class LineParser {

  private LineParser() {
    // private constructor for utility class.
  }

  static StockItem parse(String line) {
    String[] splitted = line.split("=");
    if (splitted.length != 2) {
      throw new LineParsingException(
          String.format("Error parsing line. Expected a single '='. '%s'", line));
    }
    String symbol = splitted[0].trim();
    try {
      BigDecimal amount = new BigDecimal(splitted[1].trim());
      return new StockItem(symbol, amount);
    } catch (NumberFormatException ex) {
      throw new LineParsingException(
          String.format("Error parsing line. Amount could not be parsed. '%s'", line), ex);
    }
  }
}
