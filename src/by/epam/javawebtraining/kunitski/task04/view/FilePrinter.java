package by.epam.javawebtraining.kunitski.task04.view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilePrinter implements Printable {

  private String outputPath;

  public FilePrinter(String outputPath) {
    this.outputPath = outputPath;
  }

  @Override
  public void print(Object text) {

    try (FileOutputStream fos = new FileOutputStream(outputPath)) {
      byte[] bytes = text.toString().getBytes();
      fos.write(bytes);

    } catch (FileNotFoundException e) {
      LogPrinter.LOGGER.error(e);

    } catch (IOException e) {
      LogPrinter.LOGGER.error(e);
    }

  }
}
