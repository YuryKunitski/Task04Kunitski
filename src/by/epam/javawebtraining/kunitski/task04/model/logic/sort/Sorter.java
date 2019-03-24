package by.epam.javawebtraining.kunitski.task04.model.logic.sort;

import by.epam.javawebtraining.kunitski.task04.model.entity.Base;
import by.epam.javawebtraining.kunitski.task04.model.entity.Composite;

import java.util.*;


public class Sorter {

  private static LengthComparator comparator = new LengthComparator();

  /**
   * method increaseText return string  sentences which
   * arranged in order of increasing sentence length.
   */

  private static List<Composite> findSentence(Composite text) {

    List<Composite> list = new ArrayList<>();
    Composite paragraphs = null;

    for (int i = 0; i < text.getSize(); i++) {

      if (text.get(i).getTextType().equals(Base.TextType.PARAGRAPH)) {
        paragraphs = (Composite) text.get(i);

        for (int j = 0; j < paragraphs.getSize(); j++) {
          list.add((Composite) paragraphs.get(j));
        }
      }
    }
    return list;
  }


  /**
   * method increaseText return string  sentences which
   * arranged in order of increasing sentence length.
   */

  public static String increaseTextLength(Composite text) {

    List<Composite> listIncrease = findSentence(text);
    listIncrease.sort(comparator);

    StringBuilder sb = new StringBuilder();
    for (Composite c : listIncrease) {
      sb.append(c.toString());
    }
    return sb.toString();
  }

  /**
   * method increaseText return string  sentences which
   * arranged in order of increasing sentence length.
   */

  public static String decreaseTextLength(Composite text) {

    List<Composite> listDecrease = findSentence(text);
    listDecrease.sort(comparator);

    StringBuilder sb = new StringBuilder();
    for (int i = listDecrease.size()-1; i >= 0 ; i--) {
      sb.append(listDecrease.get(i).toString());
    }
    return sb.toString();
  }
}
