package week_5.keepbang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class CommendStack {

  public static void main(String[] args) throws IOException {
    commendStack();
  }

  public static void commendStack() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      String commend = br.readLine();
      if (commend.startsWith("push")) {
        int num = Integer.parseInt(commend.split(" ")[1]);
        stack.push(num);
      } else if (commend.equals("pop")) {
        System.out.println(stack.pop());
      } else if (commend.equals("size")) {
        System.out.println(stack.size());
      } else if (commend.equals("empty")) {
        System.out.println(stack.isEmpty() ? 1 : 0);
      } else if (commend.equals("top")) {
        System.out.println(stack.peek());
      } else {
        System.out.println("wrong commend");
        i--;
      }
    }
  }
}
