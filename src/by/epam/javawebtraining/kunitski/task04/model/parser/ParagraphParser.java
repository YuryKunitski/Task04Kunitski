package by.epam.javawebtraining.kunitski.task04.model.parser;

import by.epam.javawebtraining.kunitski.task04.model.entity.Composite;
import by.epam.javawebtraining.kunitski.task04.model.entity.Element;
import by.epam.javawebtraining.kunitski.task04.view.LogPrinter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author
 */
public class ParagraphParser extends Parsable {

  private final String REGEX_SPLIT = "(\n\\s\n)";
  private final String REGEX_PARAGRAPH = "^[A-Z].*[^;](\\s+$)";

  public ParagraphParser(Parsable next) {
    super(next);
  }

  @Override
  public Composite parse(String text) {
    LogPrinter.LOGGER.info("Start method parse in class ParagraphParser");

    Composite paragraphComposite = new Composite(Composite.TextType.TEXT);
    String[] paragraphStrings = text.split(REGEX_SPLIT);

    for (String s : paragraphStrings) {
      Matcher matcher = Pattern.compile(REGEX_PARAGRAPH, Pattern.MULTILINE).matcher(s);
      if (matcher.find()) {    //is paragraph?
        paragraphComposite.add(next.parse("\n"+s+"\n"));
      } else {     // it's code block!
       Element codeBlock = new Element("\n\n"+s+"\n" ,Element.TextType.CODE_BLOCK);
        paragraphComposite.add(codeBlock);
      }
    }

    LogPrinter.LOGGER.info("Finish method parse in class ParagraphParser");
    return paragraphComposite;
  }
}
