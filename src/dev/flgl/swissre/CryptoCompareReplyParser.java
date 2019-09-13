package dev.flgl.swissre;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Parser for the reply of the crypto service. CryptoCompareReplyParser.parse() returns the exchange
 * rate. This parser uses the javascript nashorn engine to parse json.
 *
 * <p>Created by Florian Glanzner (florian.glanzner@gmail.com) on 12.09.2019.
 */
class CryptoCompareReplyParser {

  private CryptoCompareReplyParser() {
    // private constructor for utility class.
  }

  static BigDecimal parse(String data, String symbol) {
    Map<String, Object> map = parseToMap(data);
    Object jsonRate = map.get(symbol);
    if (jsonRate == null) {
      // Usually happens when the symbol is unknown to the service
      String message = (String) map.get("Message");
      throw new ResolveExchangeRateException("Error querying crypto service: " + message);
    }
    return convertRateType(jsonRate);
  }

  private static Map<String, Object> parseToMap(String data) {
    try {
      ScriptEngineManager sem = new ScriptEngineManager();
      ScriptEngine engine = sem.getEngineByName("javascript");
      return (Map<String, Object>) engine.eval("Java.asJSONCompatible(" + data + ")");
    } catch (ScriptException ex) {
      throw new ResolveExchangeRateException("Error querying crypto service.", ex);
    }
  }

  private static BigDecimal convertRateType(Object jsonRate) {
    if (jsonRate instanceof Double) {
      return BigDecimal.valueOf((Double) jsonRate);
    } else if (jsonRate instanceof Integer) {
      return BigDecimal.valueOf((Integer) jsonRate);
    } else {
      throw new ResolveExchangeRateException(
          "Could not interpret value of exchange rate " + jsonRate);
    }
  }
}
