package by.epam.javawebtraining.kunitski.task04.model.parser;

import by.epam.javawebtraining.kunitski.task04.model.entity.Composite;

public abstract class Parsable {

  protected Parsable next;

  public Parsable(){}

  public Parsable(Parsable next){
    this.next = next;
  }

  public abstract Composite parse(String text);
}
