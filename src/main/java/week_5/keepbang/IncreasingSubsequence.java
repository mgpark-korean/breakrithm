package week_5.keepbang;

import java.util.Stack;

public class IncreasingSubsequence {

  public static void main(String[] args) {
    int[] arr = {10, 30, 20, 50, 60, 15};
    increasingSubsequence(arr);
  }

  public static void increasingSubsequence(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      int val = arr[i];
      // 스택이 비어있거나 배열의 값이 스택의 맨 위의 값보다 클 경우
      if (stack.isEmpty() || val > stack.peek()) {
        stack.push(val);
        System.out.println("val = " + val);
      }
    }
  }

}
