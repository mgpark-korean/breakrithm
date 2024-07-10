package week_5.jshan;

public class StackArr {
  private int[] arr;
  private int size;
  private int maxSize;

  public StackArr(int maxSize) {
    this.maxSize = maxSize;
    this.arr = new int[maxSize];
    this.size = 0;
  }

  public static void main(String[] args){

    try {
      StackArr stack = new StackArr(5);
      stack.push(1);
      stack.push(2);
      stack.push(3);
      stack.push(4);
      stack.push(7);

      System.out.println(stack.pop()); //7
      System.out.println(stack.pop()); //4
      System.out.println(stack.pop()); //3
      System.out.println(stack.pop()); //2
      System.out.println(stack.pop()); //1
      System.out.println(stack.pop()); // error
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void push(int value) {
    if (this.size == this.maxSize) {
      throw new RuntimeException("arr size is reach to limit size.");
    }
    arr[size] = value;
    size++;
  }

  public int pop() {
    if (size == 0) {
      throw new RuntimeException("there is nothing to pop.");
    }
    int last = arr[size-1];
    arr[size-1] = 0;
    size--;

    return last;

  }
}
