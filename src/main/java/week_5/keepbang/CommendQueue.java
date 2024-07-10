package week_5.keepbang;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CommendQueue {

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      String input = sc.next();
      switch (input) {
        case "push" -> queue.add(sc.nextInt());
        case "pop" -> System.out.println(queue.poll());
        case "size" -> System.out.println(queue.size());
        case "empty" -> System.out.println(queue.isEmpty() ? 1 : 0);
        case "front" -> System.out.println(queue.peek());
        default -> {
          System.out.println("error");
          i--;
        }
      }

    }
  }
}
