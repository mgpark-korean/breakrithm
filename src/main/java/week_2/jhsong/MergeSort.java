package week_2.jhsong;

import java.util.ArrayList;

public class MergeSort {
    public static final int MAX_DIGIT = 10;

    private static int[] mergedArr;

    public void solution() {
        int [] arr = {6, 1, 4, 8, 3, 9, 2, 5};
        int n = arr.length;

        mergedArr = new int[n]; // 병합 배열 초기화
        mergeSort(arr, 0, n - 1);

        for(int i=0; i<arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }

    public void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(arr, low, mid); // 좌측 정렬
            mergeSort(arr, mid + 1, high); // 우측 정렬
            merge(arr, low, mid, high); // 배열 병합
        }
    }

    public void merge(int [] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int i = low; // 정렬에 사용할 index

        // 좌측, 우측에 정렬할 값이 있다면 실행
        while (left <= mid && right <= high) {
            // 좌측이 크면 i + 1, 우측이 크면 j + 1
            if (arr[left] <= arr[right]) {
                mergedArr[i] = arr[left];
                i++; left++;
            } else { //
                mergedArr[i] = arr[right];
                i++; right++;
            }
        }

        // 좌측에 값이 남이있는 경우
        while (left <= mid) {
            mergedArr[i] = arr[left];
            i++; left++;
        }

        // 우측에 값이 남이있는 경우
        while (right <= high) {
            mergedArr[i] = arr[right];
            i++; right++;
        }

        // 병합된 리스트 원본에 넣기
        for (i = low; i <= high; i++) {
            arr[i] = mergedArr[i];
        }
    }


    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        mergeSort.solution();
    }
}
