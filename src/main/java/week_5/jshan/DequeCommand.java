package week_5.jshan;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeCommand {
  public static void main(String[] args){
    String[] commands = {
        "push_back 1"
        ,"push_front 2"
        ,"push_front 3"
        ,"pop_front"
        ,"front"
        ,"pop_back"
        ,"back"
        ,"size"
        ,"empty"
        ,"pop_back"
        ,"push_front 3"
        ,"empty"
        ,"back"
    };

    String[] commands2 = {
        "push_front 1"
        ,"front"
        ,"pop_back"
        ,"push_back 2"
        ,"back"
        ,"pop_front"
        ,"push_front 10"
        ,"push_front 333"
        ,"front"
        ,"back"
        ,"pop_back"
        ,"pop_back"
        ,"push_back 20"
        ,"push_back 1234"
        ,"front"
        ,"back"
        ,"pop_back"
        ,"pop_back"
    };

    Deque<Integer> dq = new ArrayDeque<>();
    for (int i=0; i<commands.length; i++) {
      doCommand(dq, commands[i]);
    }

    System.out.println("command1 completed");

    Deque<Integer> dq2 = new ArrayDeque<>();
    for (int i=0; i<commands2.length; i++) {
      doCommand(dq2, commands2[i]);
    }
    System.out.println("command2 completed");

  }

  static void doCommand(Deque<Integer> dq, String command) {
    if (command.startsWith("push_front")) {
      String[] cmdArr = command.split(" ");
      String cmd = cmdArr[0];
      int value = Integer.parseInt(cmdArr[1]);
      dq.addFirst(value);
    } else if (command.startsWith("push_back")) {
      String[] cmdArr = command.split(" ");
      String cmd = cmdArr[0];
      int value = Integer.parseInt(cmdArr[1]);
      dq.addLast(value);
    }else if (command.startsWith("pop_front")) {
      System.out.println(dq.pollFirst());
    }else if (command.startsWith("pop_back")) {
      System.out.println(dq.pollLast());
    }else if (command.startsWith("size")) {
      System.out.println(dq.size());
    }else if (command.startsWith("empty")) {
      System.out.println(dq.isEmpty() ? 1 : 0);
    }else if (command.startsWith("front")) {
      System.out.println(dq.peekFirst());
    }else if (command.startsWith("back")) {
      System.out.println(dq.peekLast());
    }
  }
}
