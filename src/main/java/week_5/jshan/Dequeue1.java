package week_5.jshan;

import java.util.Deque;
import java.util.LinkedList;

public class Dequeue1 {
  public static void main(String[] args){
    Deque<Integer> dq = new LinkedList<>();
    dq.addLast(15);
    dq.addFirst(20);
    dq.addLast(25);
    dq.addLast(30);

    System.out.println(dq.pollLast());
    System.out.println(dq.pollFirst());
    dq.addLast(27);
    System.out.println(dq.size());
    System.out.println(dq.pollLast());
    System.out.println(dq.pollFirst());
  }
}
