package by.epam.javawebtraining.kunitski.task04.model.logic.sort;

import by.epam.javawebtraining.kunitski.task04.model.entity.Composite;
import by.epam.javawebtraining.kunitski.task04.model.parser.ParagraphParser;
import by.epam.javawebtraining.kunitski.task04.model.parser.Parsable;
import by.epam.javawebtraining.kunitski.task04.model.parser.SentenceParser;
import by.epam.javawebtraining.kunitski.task04.model.parser.WordParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SorterTest {
  private Composite compositeActual;

  @Before
  public void initialize() {
    String text = "Hello. My name is Yury. I am 27. I want to be a Java developer.\n\n " +
            "I study at Epam's training.";
    Parsable parser = new ParagraphParser(new SentenceParser(new WordParser()));
    compositeActual = parser.parse(text);
  }

  @After
  public void unInit() {
    compositeActual = null;
  }

  @Test
  public void increaseTextLength() {
    String textExpected = "\nHello. I am 27. My name is Yury. I study at Epam's training. " +
            "I want to be a Java developer.";
    String textActual = Sorter.increaseTextLength(compositeActual);
    assertEquals(textExpected, textActual);

  }

  @Test
  public void decreaseTextLength() {
    String textExpect = " I want to be a Java developer. I study at Epam's training. " +
            "My name is Yury. I am 27.\nHello.";
    String textActuality = Sorter.decreaseTextLength(compositeActual);
    assertEquals(textExpect, textActuality);
  }
}