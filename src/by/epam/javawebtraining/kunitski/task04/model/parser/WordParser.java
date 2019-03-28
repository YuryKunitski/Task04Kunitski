package by.epam.javawebtraining.kunitski.task04.model.parser;

import by.epam.javawebtraining.kunitski.task04.model.entity.Composite;
import by.epam.javawebtraining.kunitski.task04.model.entity.Element;
import by.epam.javawebtraining.kunitski.task04.model.reader.Reader;
import by.epam.javawebtraining.kunitski.task04.view.LogPrinter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends Parsable {

  private final String REGEX = "\\s?\\w*\\p{Punct}?\\n*";


  @Override
  public Composite parse(String sentence) {
    LogPrinter.LOGGER.info("Method parse started in class WordParser");

    Composite wordComposite = new Composite(Composite.TextType.SENTENCE);
    Matcher matcher = Pattern.compile(REGEX).matcher(sentence);

    while (matcher.find()) {
//      System.out.print(matcher.group());
      Element word = new Element(matcher.group(), Element.TextType.WORD);
      wordComposite.add(word);
    }

    LogPrinter.LOGGER.info("Method parse finished in class WordParser");
    return wordComposite;
  }

  public static void main(String[] args) {
    String textFromFile = Reader.readFile("data//input//text.txt");
    Parsable parser = new WordParser();
    Composite word = parser.parse(textFromFile);
//    System.out.println(word.get(0) + " " + word.get(1) + " " + word.get(2) + " " + word.get(3));
  }

}
