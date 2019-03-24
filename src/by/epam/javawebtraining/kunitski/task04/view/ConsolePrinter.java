package by.epam.javawebtraining.kunitski.task04.view;

public class ConsolePrinter implements Printable {

  @Override
  public void print(Object o) {
    System.out.println(o);
  }
}
