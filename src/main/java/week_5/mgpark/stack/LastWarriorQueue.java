package week_5.mgpark.stack;

import java.util.LinkedList;
import java.util.List;

public class LastWarriorQueue {

  public static void main(String[] args) {
    lastWarrior(5, 3);
  }

  public static void lastWarrior(int warriorCount, int killPosition) {
    Queue queue = new Queue();

    if (warriorCount < 0 || killPosition < 0) {
      throw new IllegalArgumentException("Invalid argument, warriorNumbers or killPosition");
    }

    for (int i = 1; i <= warriorCount; i++) {
      queue.push(i);
    }
    System.out.println("척살 대상 전사들");
    queue.print();

    System.out.println("척살 대상 시작");
    int killCursor = 1;
    while (!queue.isEmpty() && queue.size() >= killPosition) {
      int target = queue.pop();
      if(killCursor == killPosition) {
        System.out.println(target + "번 전사 사망.");
        killCursor = 1;
      } else {
        queue.push(target);
        killCursor++;
      }
    }

    System.out.println("생존한 전사들.");
    queue.print();
  }

  private static class Queue {
    private final List<Integer> numbers;

    public Queue() {
      this.numbers = new LinkedList<>();
    }

    public void push(int number) {
      numbers.add(number);
    }

    public int pop() {
      return numbers.remove(0);
    }

    public int size() {
      return numbers.size();
    }

    public boolean isEmpty() {
      return numbers.isEmpty();
    }

    public int front() {
      return numbers.get(0);
    }

    public void print() {
      numbers.forEach(number -> System.out.print(number + " "));
    }
  }
}
