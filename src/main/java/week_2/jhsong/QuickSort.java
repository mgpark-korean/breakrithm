package week_2.jhsong;

import java.util.ArrayList;

public class QuickSort {
    public void solution() {
        int [] arr = {720, 329, 436, 839, 355, 457, 657};

        quickSort(arr, 0, arr.length -1);

        for(int i=0; i<arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pos = partition(arr, low, high);

            quickSort(arr, low, pos-1); // 좌측
            quickSort(arr, pos + 1, high); // 우측
        }
    }

    public int partition(int [] arr, int low, int high) {
        // pivot 설정이 중요 (가장 왼쪽, 가운데, 가장 오른쪽)
        // 데이터 수가 3개 이상인 경우 가장 오른쪽
        int pivot = arr[high];
        int i = low - 1;

        for (int j=low; j<high; j++) {
            // 반복하면서 값이 pivot 보다 작은지 확인하고 swap
            if (arr[j] < pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // pivot 위치 재조정
        int temp = arr[i + 1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.solution();
    }
}
