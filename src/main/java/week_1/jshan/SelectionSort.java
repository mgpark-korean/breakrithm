package week_1.jshan;


public class SelectionSort {
  public static void main(String[] args) {

    int[] nArr = {9,10,2,4,5,1};
//                  1 10 2 4 5 9
//                  1 2 10 4 5 9
//                  1 2 4 10 5 9
//                  1 2 4 5 10 9
//                  1 2 4 5 9 10
    sortBySelection(nArr);
    for (int i=0; i<nArr.length; i++) {
      System.out.print(nArr[i] + " ");
    }
  }

  public static void sortBySelection(int[] arr) {
    int length = arr.length;

    for (int i=0; i<length-1; i++) {
      int minIdx = i;
      // 0번 idx 부터 하나씩 채워 간다.
      // 가장 작은 idx를 루프를 돌면서 찾는다.
      for (int j=i+1; j<length; j++) {
        if (arr[minIdx] > arr[j]) {
          minIdx = j;

        }
      }
      // 치환
      int temp = arr[i];
      arr[i] = arr[minIdx];
      arr[minIdx] = temp;
    }
  }
}
