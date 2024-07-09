package week5.jshan;

import java.util.Stack;

public class Stack1 {
  public static void main(String[] args) {
    // 스택 생성
    Stack<Integer> s = new Stack<>();

    // 값 푸시
    s.push(15);
    s.push(20);
    s.push(35);
    s.push(20);

    // 값 팝하고 출력
    System.out.println(s.pop());
    System.out.println(s.pop());

    // 스택 크기 출력
    System.out.println(s.size());

    // 스택 맨 위 값 확인하고 출력
    System.out.println(s.peek());

    // 값 팝하고 출력
    System.out.println(s.pop());
  }
}

