package by.epam.javawebtraining.kunitski.task04.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Base {

  private List<Base> components;
  private int size;

  public Composite(TextType compositeType) {
    super(compositeType);
    components = new ArrayList<>();
  }

  public int getSize(){
    return size;
  }

  public void add(Base base) {
    components.add(base);
    size++;
  }

  public void remove(Base base) {
    components.remove(base);
    size--;
  }

  public Base get(int index) {
    if (index >= 0 && index < components.size()) {
      return components.get(index);
    } else {
      return null;
    }
  }

  public void setElement(int index, Base word){
    if (word != null && index >= 0 && index < size){
      components.set(index, word);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Composite composite = (Composite) o;

    if (size != composite.size) return false;
    return components != null ? components.equals(composite.components) : composite.components == null;
  }

  @Override
  public int hashCode() {
    int result = components != null ? components.hashCode() : 0;
    result = 31 * result + size;
    return result;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();

    for (Base base : components){
      sb.append(base);
    }
    return sb.toString();
  }
}
