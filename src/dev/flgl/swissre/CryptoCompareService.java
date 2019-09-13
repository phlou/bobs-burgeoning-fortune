package dev.flgl.swissre;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.util.Scanner;

/** Created by Florian Glanzner (florian.glanzner@gmail.com) on 11.09.2019. */
class CryptoCompareService {

  private CryptoCompareService() {
    // private constructor for utility class.
  }

  private static final String CRYPTO_COMPARE_SERVICE_URL =
      "https://min-api.cryptocompare.com/data/price?fsym=%s&tsyms=%s";

  static BigDecimal getExchangeRate(String fromSymbol, String targetSymbol) {
    String urlString = String.format(CRYPTO_COMPARE_SERVICE_URL, fromSymbol, targetSymbol);
    try {
      URL url = new URL(urlString);
      InputStream is = url.openConnection().getInputStream();
      Scanner s = new Scanner(is).useDelimiter("\\A");
      String content = s.hasNext() ? s.next() : "";

      return CryptoCompareReplyParser.parse(content, targetSymbol);
    } catch (IOException ex) {
      throw new ResolveExchangeRateException("Error connecting to cryptocompare service", ex);
    }
  }
}
