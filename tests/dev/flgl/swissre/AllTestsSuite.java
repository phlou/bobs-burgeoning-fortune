package dev.flgl.swissre;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Testsuite that contains all Testclasses. This helps to run all test from commandline.
 *
 * <p>Created by Florian Glanzner (florian.glanzner@gmail.com) on 13.09.2019.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
  CryptoCompareServiceTest.class,
  CryptoCompareReplyParserTest.class,
  LineParserTest.class,
  StockFileReaderTest.class,
  BobsFortuneCalculatorTest.class
})
public class AllTestsSuite {
  // Junit tests
}
