package by.epam.javawebtraining.kunitski.task04.model.parser;

import by.epam.javawebtraining.kunitski.task04.model.entity.Composite;
import by.epam.javawebtraining.kunitski.task04.model.reader.Reader;
import by.epam.javawebtraining.kunitski.task04.view.LogPrinter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends Parsable {

  private final String REGEX = "\\w*([^.!?:]+[.!?:])";


  public SentenceParser(Parsable next) {
    super(next);
  }

  @Override
  public Composite parse(String paragraph) {
    LogPrinter.LOGGER.info("Method parse started in class SentenceParser");

    Composite sentenceComposite = new Composite(Composite.TextType.PARAGRAPH);
    Matcher matcher = Pattern.compile(REGEX).matcher(paragraph);

    while (matcher.find()){
//      System.out.print("SENTENCE - "+matcher.group());
      sentenceComposite.add(next.parse(matcher.group()));
    }

    LogPrinter.LOGGER.info("Method parse finished in class SentenceParser");
    return sentenceComposite;
  }

  public static void main(String[] args) {
    String textFromFile = Reader.readFile("data//input//text.txt");
    Parsable parser = new SentenceParser(new WordParser());
    Composite sentence = parser.parse(textFromFile);
//    System.out.println(sentence.get(0) + " " + sentence.get(1) + " " + sentence.get(2) + " " + sentence.get(3));
  }

}


