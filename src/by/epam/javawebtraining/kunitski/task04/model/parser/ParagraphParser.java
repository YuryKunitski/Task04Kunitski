package by.epam.javawebtraining.kunitski.task04.model.parser;

import by.epam.javawebtraining.kunitski.task04.model.entity.Composite;
import by.epam.javawebtraining.kunitski.task04.model.entity.Element;
import by.epam.javawebtraining.kunitski.task04.model.reader.Reader;
import by.epam.javawebtraining.kunitski.task04.view.LogPrinter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author
 */
public class ParagraphParser extends Parsable {

  private final String REGEX_SPLIT = "(\n\\s?\n)";
  private final String REGEX_PARAGRAPH = "^[A-Z].*[^;](\\s+\n+$)";   //"^[A-Z].*[^;](\\s+$)";

  public ParagraphParser(Parsable next) {
    super(next);
  }

  @Override
  public Composite parse(String text) {
    LogPrinter.LOGGER.info("Method parse started in class ParagraphParser");

    Composite paragraphComposite = new Composite(Composite.TextType.TEXT);
    String[] paragraphStrings = text.split(REGEX_SPLIT);

    for (String s : paragraphStrings) {
//      System.out.print("--------->"+s);
      Matcher matcher = Pattern.compile(REGEX_PARAGRAPH, Pattern.MULTILINE).matcher(s);
      if (matcher.find()) {    //is paragraph?
//        System.out.print("PARAGRAPH - " + matcher.group());
        paragraphComposite.add(next.parse(s));
      } else {     // it's code block!
//        System.out.print("CODE BLOCK - "+ s);
       Element codeBlock = new Element("\n"+s+"\n" ,Element.TextType.CODE_BLOCK);
        paragraphComposite.add(codeBlock);
      }
    }

    LogPrinter.LOGGER.info("Method parse finished in class ParagraphParser");
    return paragraphComposite;
  }

  public static void main(String[] args) {
    String textFromFile = Reader.readFile("data//input//text.txt");
    Parsable parser = new ParagraphParser(new SentenceParser(new WordParser()));
    Composite paragraph = parser.parse(textFromFile);
//    System.out.println(sentence.get(0) + " " + sentence.get(1) + " " + sentence.get(2) + " " + sentence.get(3));
  }
}
