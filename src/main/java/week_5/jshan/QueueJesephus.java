package week_5.jshan;

import java.util.LinkedList;
import java.util.Queue;

public class QueueJesephus {

  public static void main(String[] args){
    Queue<Integer> queue = new LinkedList<>();
    for (int i=0; i<10; i++) {
      queue.add(i);
    }
    System.out.println("init queue ");
    queue.forEach(i -> System.out.print(i+" "));
    System.out.println();
    System.out.println(solution(queue, 3));
  }

  public static int solution(Queue<Integer> queue, int k) {
    while(queue.size() > 1) {
      for (int i=0; i<k; i++) {
        queue.add(queue.peek());
        queue.poll();
      }
      queue.forEach(i -> System.out.print(i+" "));
      System.out.println();
      System.out.println("poll : "+queue.poll());

    }
    return queue.peek();
  }
}
