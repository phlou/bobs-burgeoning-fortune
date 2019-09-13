package dev.flgl.swissre;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/** Created by Florian Glanzner (florian.glanzner@gmail.com) on 11.09.2019. */
public class CryptoCompareReplyParserTest {

  @Test
  public void parseForDouble() {
    String data = "{\"EUR\":9354.02}";
    BigDecimal result = CryptoCompareReplyParser.parse(data, "EUR");
    assertEquals(new BigDecimal("9354.02"), result);
  }

  @Test
  public void parseForInteger() {
    String data = "{\"EUR\":23456789}";
    BigDecimal result = CryptoCompareReplyParser.parse(data, "EUR");
    assertEquals(new BigDecimal("23456789"), result);
  }

  @Test(expected = ResolveExchangeRateException.class)
  public void parseThrowsForEmptyReply() {
    String data = "{\"Message\":\"a message\"}";
    BigDecimal result = CryptoCompareReplyParser.parse(data, "EUR");
  }

  @Test(expected = ResolveExchangeRateException.class)
  public void parseThrowsForBadRate() {
    String data = "{\"EUR\":\"1\"}";
    BigDecimal result = CryptoCompareReplyParser.parse(data, "EUR");
  }
}
