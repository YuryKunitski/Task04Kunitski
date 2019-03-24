package by.epam.javawebtraining.kunitski.task04.view;

import org.apache.log4j.Logger;

public class LogPrinter implements Printable {

  public static final Logger LOGGER = Logger.getRootLogger();

  @Override
  public void print(Object o) {
    LOGGER.info(o);
  }
}
