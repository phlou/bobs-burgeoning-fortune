package dev.flgl.swissre;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/** Created by Florian Glanzner (florian.glanzner@gmail.com) on 12.09.2019. */
public class LineParserTest {

  @Test
  public void parse() {
    String line = "BTC=1000";
    StockItem result = LineParser.parse(line);
    assertEquals("BTC", result.getSymbol());
    assertEquals(new BigDecimal("1000"), result.getAmount());
  }

  @Test
  public void parseHandlesWithspace() {
    String line = " ABC\t= 1 ";
    StockItem result = LineParser.parse(line);
    assertEquals("ABC", result.getSymbol());
    assertEquals(new BigDecimal("1"), result.getAmount());
  }

  @Test
  public void parseHandlesFractionalAmount() {
    String line = "XXXXXXXXXXXXXXX=3.1416";
    StockItem result = LineParser.parse(line);
    assertEquals("XXXXXXXXXXXXXXX", result.getSymbol());
    assertEquals(new BigDecimal("3.1416"), result.getAmount());
  }

  @Test(expected = LineParsingException.class)
  public void parseThrowsParsingErrorForBadLine() {
    String line = "A 1";
    StockItem result = LineParser.parse(line);
  }

  @Test(expected = LineParsingException.class)
  public void parseThrowsParsingErrorForBadAmount() {
    String line = "A=a";
    StockItem result = LineParser.parse(line);
  }
}
