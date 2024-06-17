package week_2.jshan;

import java.util.Arrays;

public class MergeSort {
  static int[] mergedArr;

  public static void main(String[] args) {
    // 여기에 코드를 작성해주세요.
    int[] nArr = {9,10,2,4,5,1};
    int n = nArr.length;
    mergedArr = new int[n];
    sortByMerge(nArr, 0, nArr.length - 1);
    Arrays.stream(nArr).forEach(i -> System.out.print(i + " "));
  }

  public static void sortByMerge(int[] arr, int low, int high) {
//     System.out.printf("sortByMerge >>> low : %d, high : %d \n", low, high);
    if (low < high) {
      int mid = (low + high) / 2;
      // 분할
      sortByMerge(arr, low, mid); // 좌측 배열 n/2 -> n/4 재귀로 1이 될때까지 쪼갠다.
      sortByMerge(arr, mid + 1, high); // 우측 배열 위와 상동
      // 정복
      doMerge(arr, low, mid, high);
    }
  }

  public static void doMerge(int[] arr, int low, int mid, int high) {

     System.out.printf("doMerge >>> low : %d, mid : %d, high : %d \n", low, mid, high);
    int i = low, j = mid + 1;
    int k = low;


    // 시작점은 중간점까지 가는 것, 중간점은 종단점 까지 가는 것
    // 비교해서 교환 하는 것
    while (i <= mid && j <= high) {
      if (arr[i] <= arr[j]) {
        mergedArr[k] = arr[i];

        i++;
      } else {
        mergedArr[k] = arr[j];
        j++;
      }
      k++;
      System.out.print("값 비교 및 치환 : ");
      Arrays.stream(mergedArr).forEach(n -> System.out.print(n + " "));
      System.out.println();
    }

    // 중간점 까지 값을 채워 주는 것
    // if (arr[i] <= arr[j])  <-- 해당절을 타지 못할 경우
    while (i <= mid) {
      mergedArr[k] = arr[i];
      i++;
      k++;
    }

    // 종단점 까지 값을 채워 주는 것
    while (j <= high) {
      mergedArr[k] = arr[j];
      j++;
      k++;
    }
    System.out.print("값 채우기 : ");
    Arrays.stream(mergedArr).forEach(n -> System.out.print(n + " "));
    System.out.println();

    // mergedArr에서 정렬된 값이 들어 있으므로 arr 배열로 치환해준다.
    // low, high 값으로 하는 이유는 해당 index 정렬이 끝났기 때문.
    for (k = low; k <= high; k++) {
      arr[k] = mergedArr[k];
    }
    System.out.println("=======================================================================");
  }
}
