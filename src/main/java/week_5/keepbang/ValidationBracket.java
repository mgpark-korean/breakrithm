package week_5.keepbang;

import java.util.Stack;

public class ValidationBracket {

  public static void main(String[] args) {
    String s = "(())((()()))[]]";
    System.out.println(solution(s));

  }

  public static boolean solution(String s) {
    char[] charArray = s.toCharArray();
    Stack<Character> stack = new Stack<>();

    for (char bracket : charArray) {
      switch (bracket) {
        case ')' -> {
          if (extracted(stack, '(')) {
            return false;
          }
        }
        case '}' -> {
          if (extracted(stack, '{')) {
            return false;
          }
        }
        case ']' -> {
          if (extracted(stack, '[')) {
            return false;
          }
        }
        default -> stack.push(bracket);
      }
    }

    return stack.isEmpty();
  }

  private static boolean extracted(Stack<Character> stack, char bracket) {
    if (stack.isEmpty()) return true;
    Character openBracket = stack.pop();
    return openBracket == null || openBracket != bracket;
  }

}
