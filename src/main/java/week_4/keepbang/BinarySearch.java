package week_4.keepbang;

public class BinarySearch {

  public static void main(String[] args) {
    int[] arr = {2, 10, 12, 16, 19, 21, 23, 24, 28, 31};
    System.out.println("binarySearch = " + binarySearch(arr, 28));

  }

  public static int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;

      if (arr[mid] == target) {
        return mid;
      }
      if (arr[mid] < target) {
        left = mid + 1;
      }
      if (arr[mid] > target) {
        right = mid - 1;
      }
    }
    return -1;
  }

}
