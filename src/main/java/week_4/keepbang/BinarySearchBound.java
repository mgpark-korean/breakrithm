package week_4.keepbang;

public class BinarySearchBound {

  public static void main(String[] args) {
    int[] arr1 = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
    int target1 = 16;
    System.out.println("LowerBound = " + LowerBound(arr1, target1));
    System.out.println("UpperBound = " + UpperBound(arr1, target1));

    int[] arr2 = {1, 3, 9, 12, 17, 21, 24, 28, 32, 35};
    int target2 = 20;
    System.out.println("LowerBound = " + LowerBound(arr2, target2));
    System.out.println("UpperBound = " + UpperBound(arr2, target2));

    int[] arr3 = {4, 8, 9, 12, 15, 18, 23, 24, 24, 26, 27, 29, 31};
    int target3 = 24;
    System.out.println("LowerBound = " + LowerBound(arr3, target3));
    System.out.println("UpperBound = " + UpperBound(arr3, target3));

  }

  public static int LowerBound(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    int min_idx = arr.length;

    while (left <= right) {
      int mid = (left + right)/ 2;
      if (arr[mid] >= target) {
        right = mid - 1;
        min_idx = Math.min(min_idx, mid);
      } else {
        left = mid + 1;
      }
    }
    return min_idx;
  }

  public static int UpperBound(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    int min_idx = arr.length;

    while (left <= right) {
      int mid = (left + right)/ 2;
      if (arr[mid] > target) {
        right = mid - 1;
        min_idx = Math.min(min_idx, mid);
      } else {
        left = mid + 1;
      }
    }
    return min_idx;
  }

}
