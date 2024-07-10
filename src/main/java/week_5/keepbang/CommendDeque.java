package week_5.keepbang;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class CommendDeque {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Deque<Integer> deque = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      String input = sc.next();
      switch (input) {
        case "push_front" -> deque.addFirst(sc.nextInt());
        case "push_back" -> deque.addLast(sc.nextInt());
        case "pop_front" -> System.out.println(deque.pollFirst());
        case "pop_back" -> System.out.println(deque.pollLast());
        case "size" -> System.out.println(deque.size());
        case "empty" -> System.out.println(deque.isEmpty() ? 1 : 0);
        case "front" -> System.out.println(deque.peekFirst());
        case "back" -> System.out.println(deque.peekLast());
        default -> {
          System.out.println("error");
          i--;
        }
      }

    }
  }

}
