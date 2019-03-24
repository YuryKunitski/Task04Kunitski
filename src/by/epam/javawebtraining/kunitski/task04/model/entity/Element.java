package by.epam.javawebtraining.kunitski.task04.model.entity;

public class Element extends Base {

  private String text;

  public Element(String text, TextType elementType){
    super(elementType);
    this.text = text;

  }

  @Override
  public String toString() {
    return text;
  }
}
