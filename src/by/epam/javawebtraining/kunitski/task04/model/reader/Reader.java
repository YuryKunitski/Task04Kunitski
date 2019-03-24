package by.epam.javawebtraining.kunitski.task04.model.reader;

import by.epam.javawebtraining.kunitski.task04.view.LogPrinter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
  public static String readFile(String dataPath) {
    LogPrinter.LOGGER.info("Start method readFile");
    StringBuilder stringBuilder = new StringBuilder();
    String line = null;

    if (dataPath != null) {
      try (BufferedReader bf = new BufferedReader(new FileReader(dataPath))) {

        while ((line = bf.readLine()) != null) {
          stringBuilder.append(line).append("\n");
        }
      } catch (IOException e) {
//        LogPrinter.LOG_FILE.error(e);
//        LogPrinter.LOG_CONSOLE.error(e);
      }
    }
    LogPrinter.LOGGER.info("Finish method readFile");
    return stringBuilder.toString();
  }
}
