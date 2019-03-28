package by.epam.javawebtraining.kunitski.task04.model.logic.change;
//
//import by.epam.javawebtraining.kunitski.task04.model.entity.Base;
//import by.epam.javawebtraining.kunitski.task04.model.entity.Composite;
//import by.epam.javawebtraining.kunitski.task04.model.entity.Element;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.*;
//
//public class ChangerTest {
//  Composite compActualText = new Composite(Base.TextType.TEXT);
//
//  @Before
//  public void initialization() {
//
//    Composite compParagraph = new Composite(Base.TextType.PARAGRAPH);
//    Composite compSentence = new Composite(Base.TextType.SENTENCE);
//
//    Element word1 = new Element("I ", Base.TextType.WORD);
//    Element word2 = new Element("will ", Base.TextType.WORD);
//    Element word3 = new Element("be ", Base.TextType.WORD);
//    Element word4 = new Element("developer ", Base.TextType.WORD);
//
//    compSentence.add(word1);
//    compSentence.add(word2);
//    compSentence.add(word3);
//    compSentence.add(word4);
//
//    compParagraph.add(compSentence);
//
//    compActualText.add(compParagraph);
//  }
//
//  @Test
//  public void changeFstWordLst() {
//    String expected = "developer will be I ";
//    Changer.changeFstWordLst(compActualText);
//    assertEquals(expected, compActualText.toString());
//
//  }
//}