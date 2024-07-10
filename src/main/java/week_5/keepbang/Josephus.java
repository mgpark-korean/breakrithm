package week_5.keepbang;

import java.util.LinkedList;
import java.util.Queue;

public class Josephus {

  public static void main(String[] args) {
    int solution = solution(5, 3);
    System.out.println("solution = " + solution);
  }

  public static int solution(int n, int k) {
    Queue<Integer> queue = new LinkedList<>();
    for (int i = 1; i <= n; i++) {
      queue.offer(i);
    }
    while (queue.size() != 1) {
      for (int i = 0; i < k - 1; i++) {
        // ex) 3번째 사람이 제거되야 한다면 2번째 사람까지는 넘어가야한다.
        // 맨앞에 있는 값을 뒤로 이동
        Integer poll = queue.poll();
        queue.offer(poll);
      }
      queue.poll();
    }

    return queue.peek();
  }

}
