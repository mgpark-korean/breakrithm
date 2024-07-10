package week_5.keepbang;

public class Fibonacci {

  public static void main(String[] args) {
    System.out.println(fibonacci(6));
    // 1 + 1 + 2 + 3 + 5 + 8 + 13
  }

  public static int fibonacci(int n) {
    System.out.println("fibo(" + n + ")");
    if (n <= 1) {
      return 1;
    }
    return fibonacci(n - 2) + fibonacci(n - 1);
  }

}
