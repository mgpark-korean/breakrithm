package week_1.jshan;

public class BubbleSort {public static void main(String[] args) {
  int[] nArr = {9,10,2,4,5,1};

  sortByBubble(nArr);
  for (int i=0; i<nArr.length; i++) {
    System.out.print(nArr[i]+" ");
  }

}

  public static void sortByBubble(int[] arr) {
    int size = arr.length;
    boolean sorted;

    do {
      sorted = true;
      for (int i=0; i<size-1; i++) {
        // 각 배열의 우측과 비교하여 작은 번호를 좌측으로 이동
        if (arr[i] > arr[i+1]) {
          int temp = arr[i];
          arr[i] = arr[i+1];
          arr[i+1] =  temp;
          sorted = false;
        }
      }
    } while (!sorted); // 만약 정렬할게 없다면 종료.
  }}
