package week_5.mgpark.stack;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack {

  public static void main(String[] args) {
  }

  private static void execute() {

  }

  private class Stack {


    private List<Integer> numbers;

    public Stack() {
      numbers = new ArrayList<>();
    }

    public void push(int x) {
      numbers.add(x);
    }

    public int pop() {
      return numbers.remove(numbers.size() - 1);
    }

    public int size() {
      return numbers.size();
    }

    public int top() {
      return numbers.get(numbers.size() - 1);
    }

    public boolean isEmpty() {
      return numbers.isEmpty();
    }
  }
}
