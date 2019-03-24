package by.epam.javawebtraining.kunitski.task04.model.parser;

import by.epam.javawebtraining.kunitski.task04.model.entity.Composite;
import by.epam.javawebtraining.kunitski.task04.view.LogPrinter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends Parsable {

  private final String REGEX = "([^.!?:]+[.!?:])";


  public SentenceParser(Parsable next) {
    super(next);
  }

  @Override
  public Composite parse(String paragraph) {
    LogPrinter.LOGGER.info("Start method parse in class SentenceParser");

    Composite sentenceComposite = new Composite(Composite.TextType.PARAGRAPH);
    Matcher matcher = Pattern.compile(REGEX).matcher(paragraph);

    while (matcher.find()){
      sentenceComposite.add(next.parse(matcher.group()));
    }

    LogPrinter.LOGGER.info("Finish method parse in class SentenceParser");
    return sentenceComposite;
  }

}


