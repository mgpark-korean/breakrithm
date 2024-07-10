package week_5.keepbang;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CircleQueue {

  public static void main(String[] args) {
    int[] s = solution(7, 3);
    Arrays.stream(s).forEach(i -> System.out.print(i + " "));
  }

  public static int[] solution(int n, int k) {
    Queue<Integer> q = new LinkedList<>();
    int[] answer = new int[n];
    int count = 0;
    for (int i = 1; i <= n; i++) {
      q.add(i);
    }
    while (!q.isEmpty()) {
      for (int i = 0; i < k - 1; i++) {
        q.add(q.poll());
      }
      answer[count++] = q.poll();
    }
    return answer;
  }
}
