package week_5.jshan;

import java.util.Stack;

public class StackBracket {
  public static void main(String[] args){
    String str1 = "(), (()), (()()), (()())((()))";
    String str2 = "), ()), (())(), (()((())())";
    System.out.println(isValidBracket(str1));
    System.out.println(isValidBracket(str2));
  }

  public static boolean isValidBracket(String str) {
    Stack<String> s = new Stack<>();
    for (int i=0; i<str.length(); i++) {
      char c = str.charAt(i);
      if (c == '(' ) {
        s.push(String.valueOf(c));
      } else if (c == ')'){
        if(s.empty()) {
          return false;
        }
        s.pop();
      }
    }
    if (!s.empty()) {
      return false;
    }
    return true;
  }
}
