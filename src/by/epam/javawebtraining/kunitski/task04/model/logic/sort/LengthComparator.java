package by.epam.javawebtraining.kunitski.task04.model.logic.sort;

import by.epam.javawebtraining.kunitski.task04.model.entity.Composite;

import java.util.Comparator;

public class LengthComparator implements Comparator<Composite> {
  @Override
  public int compare(Composite comp1, Composite comp2) {
    return comp1.getSize() - comp2.getSize();
  }
}
