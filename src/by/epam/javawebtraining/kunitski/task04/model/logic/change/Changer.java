package by.epam.javawebtraining.kunitski.task04.model.logic.change;

import by.epam.javawebtraining.kunitski.task04.model.entity.Base;
import by.epam.javawebtraining.kunitski.task04.model.entity.Composite;
import by.epam.javawebtraining.kunitski.task04.model.entity.Element;

public class Changer {

  /**
   * This method change first word with last in the sentences.
   */

  public static void changeFstWordLst(Composite text) {

    Composite paragraphs = null;
    Composite sentences = null;
    Element firstWord = null;

    for (int i = 0; i < text.getSize(); i++) {

      if (text.get(i).getTextType().equals(Base.TextType.PARAGRAPH)) {
        paragraphs = (Composite) text.get(i);

        for (int j = 0; j < paragraphs.getSize(); j++) {
          sentences = (Composite) paragraphs.get(j);
          firstWord = (Element) sentences.get(0);
          sentences.setElement(0, sentences.get(sentences.getSize() - 1));
          sentences.setElement(sentences.getSize() - 1, firstWord);
        }
      }
    }
  }
}
