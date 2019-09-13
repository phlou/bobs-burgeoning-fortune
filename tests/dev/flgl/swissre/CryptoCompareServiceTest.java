package dev.flgl.swissre;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertNotNull;

/** Created by Florian Glanzner (florian.glanzner@gmail.com) on 11.09.2019. */
public class CryptoCompareServiceTest {

  @Test
  public void read() {
    BigDecimal result = CryptoCompareService.getExchangeRate("BTC", "EUR");
    assertNotNull(result);
  }

  @Test(expected = ResolveExchangeRateException.class)
  public void readThrowsForBadSymbol() {
    BigDecimal result = CryptoCompareService.getExchangeRate("XXYY", "EUR");
  }
}
