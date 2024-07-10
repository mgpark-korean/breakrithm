package week_5.mgpark.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BracketStack {

  public static void main(String[] args) {
    System.out.println("괄호 문자열 검증 결과 : " + isValidBracket("()()"));
    System.out.println("괄호 문자열 검증 결과 : " + isValidBracket("())("));
    System.out.println("괄호 문자열 검증 결과 : " + isValidBracket("(())((()()))"));
    System.out.println("괄호 문자열 검증 결과 : " + isValidBracket("(), (()), (()()), (()())((()))"));
    System.out.println("괄호 문자열 검증 결과 : " + isValidBracket("), ()), (())(), (()((())())"));
  }

  private static boolean isValidBracket(String brackets) {
    try {
      Stack stack = new Stack();

      if (brackets == null || brackets.trim().isEmpty()) {
        return true;
      }

      for (char c : brackets.toCharArray()) {
        stack.push(c);
      }

      return stack.isEmpty();
    } catch (Exception e) {
      return false;
    }
  }

  private static class Stack {

    private final List<Character> stack;

    public Stack() {
      this.stack = new ArrayList<>();
    }

    public void push(char c) throws Exception {
      if (this.isCloseBracketString(c) && this.isEmpty()) {
        throw new Exception("올바르지 않은 괄호 입니다.");
      }

      if (this.isCloseBracketString(c)) {
        this.clearToOpenBracket();
      } else if (this.isOpenBracketString(c)) {
        stack.add(c);
      }
    }

    public Character pop() {
      return stack.removeLast();
    }

    public boolean isEmpty() {
      return stack.isEmpty();
    }

    private boolean isOpenBracketString(char c) {
      return c == '(' || c == '{' || c == '[';
    }

    private boolean isCloseBracketString(char c) {
      return c == ')' || c == '}' || c == ']';
    }

    /**
     * 열린 괄호 까지 stack pop
     */
    private void clearToOpenBracket() {
      Character popped = 'a';

      while (!isOpenBracketString(popped) && !this.isEmpty()) {
        popped = this.pop();
      }
    }
  }
}
