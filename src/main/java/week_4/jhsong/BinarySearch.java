package week_4.jhsong;

import java.util.ArrayList;
import java.util.Arrays;

public class BinarySearch {
    // 이진 탐색은 index 위치의 중간을 찾아 왼쪽 또는 오른쪽으로 탐색할 때 사용
    // 데이터는 사전에 정렬되어 있어야 함
    // 시간복잡도; O(logN)

    public int solution(int [] arr, int searchValue) {
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        ArrayList<Integer> indexedArray = new ArrayList<>();
        for (int i=0; i<arr.length ; i++) {
            indexedArray.add(i);
        }

        System.out.printf("searchValue: %s\n", searchValue);
        while (left <= right) {
            mid = (left + right) / 2;
            System.out.println("------------------------------------------");
            Arrays.stream(indexedArray.toArray()).forEach(i -> System.out.printf("%2d ", i));
            System.out.println();
            Arrays.stream(arr).forEach(i -> System.out.printf("%2d ", i));
            System.out.println();
            System.out.printf("left: %d, right: %d, mid: %d\n", left, right, mid);
            System.out.println("------------------------------------------");

            if (arr[mid] == searchValue) {
                System.out.printf("%d 위치에서 발견!\n", mid);
                return mid;
            }

            if (arr[mid] > searchValue) {
                right = mid - 1;
                System.out.printf("arr[%d], %d > %d, right 좌측으로 이동\n\n", mid, arr[mid], searchValue);
            } else {
                left = mid + 1;
                System.out.printf("arr[%d], %d < %d, left 우측으로 이동\n\n", mid, arr[mid], searchValue);
            }
        }

        System.out.printf("left: %d, right: %d, mid: %d\n", left, right, mid);
        System.out.println("검색 불가!");
        return -1;
    }

    public void problem4NotSortedArray() {
        int [] arr = {1, 17, 32, 24, 3, 12, 28, 9, 21};
        solution(arr, 21);
    }

    public void problem6DuplicateValue() {
        // case 1
        System.out.println("case 1");
        int [] case1Array = {5, 5, 5, 8, 8, 8, 11, 12, 13, 15, 16, 19, 19, 19};
        solution(case1Array, 19);



        // case 2
        System.out.println("\ncase 2");
        int [] case2Array = {4, 8, 9, 12, 15, 18, 23, 24, 24, 26, 27, 29, 31};
        solution(case2Array, 24);

    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();

        binarySearch.problem4NotSortedArray();
        binarySearch.problem6DuplicateValue();
//
//        int searchedIndex = binarySearch.problem4NotSortedArray();
//        if (searchedIndex == -1) {
//            System.out.printf("값이 없습니다. 리턴값: %d", searchedIndex);
//        } else {
//            System.out.printf("검색된 위치: %d%n", searchedIndex);
//        }

    }
}
