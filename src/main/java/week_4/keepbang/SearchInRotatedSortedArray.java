package week_4.keepbang;

import java.util.Arrays;

public class SearchInRotatedSortedArray {

  public static void main(String[] args) {

    int[] nums = {9,10,11,0,1,2,3,4,5,6,7,8};
    int target = 1;

    Arrays.sort(nums);

    int i = Arrays.binarySearch(nums, target);

    SearchInRotatedSortedArray sol = new SearchInRotatedSortedArray();

    int result = sol.search(nums, target);
    System.out.println("Index of target: " + result); // 출력: 4
  }

  public int search(int[] nums, int target) {
    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;

      if (nums[mid] == target) {
        return mid;
      }

      if (nums[left] <= nums[mid]) {
        
        if (nums[left] <= target && target < nums[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
        
        
      } else {
        if (nums[mid] < target && target <= nums[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

//    nums[start]가 nums[mid]보다 작다면, 이는 배열의 왼쪽 부분이 정렬되어 있다는 것을 의미합니다.
//    만약 target이 이 정렬된 부분 내에 있다면, 왼쪽 부분을 탐색 범위로 설정합니다.
//    그렇지 않다면, 오른쪽 부분을 탐색 범위로 설정합니다.

    return -1;
  }

  public int recursiveSearch(int[] nums, int left, int right, int target) {
    if (left > right) {
      return -1;
    }
    int mid = (left + right) / 2;
    if (nums[mid] == target) {
      return mid;
    }
    if (nums[mid] < target) {
      return recursiveSearch(nums, mid + 1, right, target);
    }
    return recursiveSearch(nums, left, mid - 1, target);
  }

}
