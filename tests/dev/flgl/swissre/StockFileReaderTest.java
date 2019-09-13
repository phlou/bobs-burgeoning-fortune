package dev.flgl.swissre;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

/** Created by Florian Glanzner (florian.glanzner@gmail.com) on 11.09.2019. */
public class StockFileReaderTest {

  @Test
  public void read() {
    StockFileReader stockFileReader = new StockFileReader("test_fixtures.txt");
    List<StockItem> items = stockFileReader.read();
    assertEquals(3, items.size());
    assertEquals("BTC", items.get(0).getSymbol());
    assertEquals(new BigDecimal("10"), items.get(0).getAmount());
  }
}
