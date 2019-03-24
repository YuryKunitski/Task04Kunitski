package by.epam.javawebtraining.kunitski.task04.controller;

import by.epam.javawebtraining.kunitski.task04.model.entity.Composite;
import by.epam.javawebtraining.kunitski.task04.model.logic.sort.Sorter;
import by.epam.javawebtraining.kunitski.task04.model.parser.ParagraphParser;
import by.epam.javawebtraining.kunitski.task04.model.parser.Parsable;
import by.epam.javawebtraining.kunitski.task04.model.parser.SentenceParser;
import by.epam.javawebtraining.kunitski.task04.model.parser.WordParser;
import by.epam.javawebtraining.kunitski.task04.model.reader.Reader;
import by.epam.javawebtraining.kunitski.task04.view.ConsolePrinter;
import by.epam.javawebtraining.kunitski.task04.view.FilePrinter;
import by.epam.javawebtraining.kunitski.task04.view.Printable;

public class Main {

  private static String outputPath = "data//output//output.txt";
  private static String inputPath = "data//input//text.txt";
  private static Printable printer = new ConsolePrinter();

  public static void main(String[] args) {

    String textFromFile = Reader.readFile(inputPath);
    Parsable parser = new ParagraphParser(new SentenceParser(new WordParser()));
    Composite wholeText = parser.parse(textFromFile);

    FilePrinter filePrinter = new FilePrinter(outputPath);
    filePrinter.print(wholeText);

//    printer.print(wholeText+"\n");
//    Changer.changeFstWordLst(wholeText);
//    printer.print("\n"+wholeText);
//    printer.print(Sorter.increaseTextLength(wholeText));
    printer.print(Sorter.decreaseTextLength(wholeText));
  }
}
