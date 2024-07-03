package week_4.jhsong;

import java.util.ArrayList;
import java.util.Arrays;

public class LowerUpperBound {
    // 이진 탐색은 index 위치의 중간을 찾아 왼쪽 또는 오른쪽으로 탐색할 때 사용
    // 데이터는 사전에 정렬되어 있어야 함

    public void solution() {
        int [] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30};
        int searchValue = 16;
        int lower = lowerBound(arr, searchValue);
        int upper = upperBound(arr, searchValue);

        System.out.printf("lower: %d, upper: %d\n", lower, upper);
        if (lower == upper) {
            System.out.println("검색 완료.");
        }
    }

    // target 이상의 값이 최초로 나오는 위치
    public int lowerBound(int [] arr, int searchValue) {
        int left = 0;
        int right = arr.length - 1;
        int minIdx = arr.length;

        ArrayList<Integer> indexedArray = new ArrayList<>();
        for (int i=0; i<arr.length ; i++) {
            indexedArray.add(i);
        }

        System.out.printf("searchValue: %s\n", searchValue);
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("------------------------------------------");
            Arrays.stream(indexedArray.toArray()).forEach(i -> System.out.printf("%2d ", i));
            System.out.println();
            Arrays.stream(arr).forEach(i -> System.out.printf("%2d ", i));
            System.out.println();
            System.out.printf("left: %d, right: %d, mid: %d\n", left, right, mid);
            System.out.println("------------------------------------------");

            if (arr[mid] >= searchValue) {
                right = mid - 1;
                System.out.printf("arr[%d], %d > %d, right 좌측으로 이동\n", mid, arr[mid], searchValue);
                minIdx = Math.min(minIdx, mid);
                System.out.printf("minIdx: %d\n\n", minIdx);
            } else {
                left = mid + 1;
                System.out.printf("arr[%d], %d < %d, left 우측으로 이동\n\n", mid, arr[mid], searchValue);
            }
        }

        return minIdx;
    }

    // target 을 초과하는 값이 최초로 나오는 위치
    public int upperBound(int [] arr, int searchValue) {
        int left = 0;
        int right = arr.length - 1;
        int minIdx = arr.length;

        ArrayList<Integer> indexedArray = new ArrayList<>();
        for (int i=0; i<arr.length ; i++) {
            indexedArray.add(i);
        }

        System.out.printf("searchValue: %s\n", searchValue);
        while (left <= right) {
            int mid = (left + right) / 2;
            System.out.println("------------------------------------------");
            Arrays.stream(indexedArray.toArray()).forEach(i -> System.out.printf("%2d ", i));
            System.out.println();
            Arrays.stream(arr).forEach(i -> System.out.printf("%2d ", i));
            System.out.println();
            System.out.printf("left: %d, right: %d, mid: %d\n", left, right, mid);
            System.out.println("------------------------------------------");

            if (arr[mid] > searchValue) {
                right = mid - 1;
                System.out.printf("arr[%d], %d > %d, right 좌측으로 이동\n", mid, arr[mid], searchValue);
                minIdx = Math.min(minIdx, mid);
                System.out.printf("minIdx: %d\n\n", minIdx);
            } else {
                left = mid + 1;
                System.out.printf("arr[%d], %d < %d, left 우측으로 이동\n\n", mid, arr[mid], searchValue);
            }
        }

        return minIdx;
    }

    public static void main(String[] args) {
        LowerUpperBound lowerUpperBound = new LowerUpperBound();
        lowerUpperBound.solution();


    }
}
