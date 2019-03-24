package by.epam.javawebtraining.kunitski.task04.model.entity;

/**
 * @author Yury Kunitski
 *
 */
public abstract class Base {

  protected TextType textType;

  public enum TextType {
    TEXT, PARAGRAPH, SENTENCE, WORD, CODE_BLOCK;
  }

  public Base(TextType textType){
    this.textType = textType;
  }

  public TextType getTextType() {
    return textType;
  }

  public abstract String toString();
}
