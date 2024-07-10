package week_5.mgpark.stack;

import java.util.Deque;
import java.util.LinkedList;

public class DequeQuestion {

  public static void main(String[] args) {
    execute(7);
  }

  public static void execute(int numberSize) {
    System.out.println("numberSize = " + numberSize);
    Deque<Integer> deque = new LinkedList<>();

    for (int i = 1; i <= numberSize; i++) {
      deque.addLast(i);
    }

    System.out.println("deque = " + deque);

    while (deque.size() > 1) {
      Integer removeNumber = deque.removeFirst();
      Integer first = deque.removeFirst();

      System.out.println("removeFirst = " + removeNumber + ", first = " + first);
      deque.addLast(first);
      System.out.println(deque);
    }

    System.out.println("last number" + deque);
  }
}
