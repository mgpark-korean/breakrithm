package week_5.jshan;

import java.util.LinkedList;
import java.util.Queue;

public class Queue1 {
  public static void main(String[] args){
    Queue<Integer> queue = new LinkedList<>();

    queue.add(15);
    queue.add(20);
    System.out.println(queue.poll()); // 15
    System.out.println(queue.poll()); // 20

    queue.add(27);
    queue.add(30);
    System.out.println(queue.size()); // 2
    System.out.println(queue.poll()); // 27
    System.out.println(queue.poll()); // 30
  }
}
