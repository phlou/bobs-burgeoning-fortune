package dev.flgl.swissre;

/** Created by Florian Glanzner (florian.glanzner@gmail.com) on 12.09.2019. */
class LineParsingException extends RuntimeException {
  LineParsingException(String message) {
    super(message);
  }

  LineParsingException(String message, Exception ex) {
    super(message, ex);
  }
}
