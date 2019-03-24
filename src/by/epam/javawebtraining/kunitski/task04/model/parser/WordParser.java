package by.epam.javawebtraining.kunitski.task04.model.parser;

import by.epam.javawebtraining.kunitski.task04.model.entity.Composite;
import by.epam.javawebtraining.kunitski.task04.model.entity.Element;
import by.epam.javawebtraining.kunitski.task04.view.LogPrinter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends Parsable {

private final String REGEX ="\\s?\\w*\\p{Punct}?[^\\s]+\\n*";


  @Override
  public Composite parse(String sentence) {
    LogPrinter.LOGGER.info("Start method parse in class WordParser");

    Composite wordComposite = new Composite(Composite.TextType.SENTENCE);
    Matcher matcher = Pattern.compile(REGEX).matcher(sentence);

    while (matcher.find()){
      Element word = new Element(matcher.group(), Element.TextType.WORD);
      wordComposite.add(word);
    }

    LogPrinter.LOGGER.info("Finish method parse in class WordParser");
    return wordComposite;
  }

}
