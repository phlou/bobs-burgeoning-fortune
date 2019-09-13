package dev.flgl.swissre;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * StockFileReader read the data file and uses LineParser to generate StockItems from each line.
 *
 * <p>Created by Florian Glanzner (florian.glanzner@gmail.com) on 11.09.2019.
 */
class StockFileReader {
  private Path path;
  private List<StockItem> items = new ArrayList<>();

  StockFileReader(String filepath) {
    path = Paths.get(filepath);
  }

  List<StockItem> read() {

    try (Stream<String> lines = Files.lines(path, Charset.defaultCharset())) {
      lines.forEachOrdered(line -> process(line));
    } catch (IOException ex) {
      System.out.println(String.format("ERROR: Could not read file at %s: %s", path, ex));
      System.exit(1);
    }
    return items;
  }

  private void process(String line) {
    items.add(LineParser.parse(line));
  }
}
