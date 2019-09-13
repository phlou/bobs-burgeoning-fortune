package dev.flgl.swissre;

/** Created by Florian Glanzner (florian.glanzner@gmail.com) on 12.09.2019. */
class ResolveExchangeRateException extends RuntimeException {
  ResolveExchangeRateException(String message) {
    super(message);
  }

  ResolveExchangeRateException(String message, Exception ex) {
    super(message, ex);
  }
}
