package week_5.keepbang;

import java.util.Deque;
import java.util.LinkedList;

public class DequeSolution {

  public static void main(String[] args) {
    int answer = solution(7);
    System.out.println("answer = " + answer);
  }

  public static int solution(int n) {
    if (n <= 0) { return 0; }

    Deque<Integer> deque = new LinkedList<>();

    for (int i = 1; i <= n; i++) {
      deque.addLast(i);
    }

    deque.forEach(i -> System.out.print(i + " "));
    System.out.println();

    while (deque.size() > 1) {
      deque.pollFirst();
      deque.addLast(deque.pollFirst());
      deque.forEach(i -> System.out.print(i + " "));
      System.out.println();
    }

    return deque.poll();
  }

}
