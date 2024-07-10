package week_5.keepbang;

import java.util.ArrayList;
import java.util.List;

public class CustomStack {

  List<Object> bucket = new ArrayList<>();

  public void push(Object o) {
    bucket.add(o);
  }

  public Object pop() {
    if (bucket.isEmpty()) {
      throw new RuntimeException("Stack is empty");
    }
    return bucket.remove(topIndex());
  }

  public int size() {
    return bucket.size();
  }

  public boolean isEmpty() {
    return bucket.isEmpty();
  }

  public Object top() {
    return bucket.get(topIndex());
  }

  private int topIndex() {
    return bucket.size() - 1;
  }

}
