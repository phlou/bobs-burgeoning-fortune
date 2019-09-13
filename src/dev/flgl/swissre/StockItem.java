package dev.flgl.swissre;

import java.math.BigDecimal;

/**
 * StockItem represents one item/line of the input data file.
 *
 * <p>Created by Florian Glanzner (florian.glanzner@gmail.com) on 11.09.2019.
 */
class StockItem {
  private String symbol;
  private BigDecimal amount;

  StockItem(String symbol, BigDecimal amount) {
    this.symbol = symbol;
    this.amount = amount;
  }

  String getSymbol() {
    return symbol;
  }

  BigDecimal getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return "StockItem{" + symbol + ", " + amount + '}';
  }
}
