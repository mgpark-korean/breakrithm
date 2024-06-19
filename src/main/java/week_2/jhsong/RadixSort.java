package week_2.jhsong;

import java.util.ArrayList;

public class RadixSort {
    public static final int MAX_DIGIT = 10;

    public void solution() {
        int [] arr = {720, 329, 436, 839, 355, 457, 657};

        radixSort(arr, 3);

        for(int i=0; i<arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
    }

    public void radixSort(int[] arr, int k) {
        // 자리수 만큼 반복이 돌아야 함
        for (int pos=k-1; pos>=0; pos--) {
//            System.out.printf("%d 번째 자리\n", pos+1);

            // ArrayList 의 배열이니 2차원인데..
            // 해당 자리수에 여러개 값이 들어감
            ArrayList<Integer>[] sortedArray = new ArrayList[MAX_DIGIT];
            for (int i=0; i<MAX_DIGIT; i++) {
                sortedArray[i] = new ArrayList<>();
            }

            // 새로만든 ArrayList 에 자리수에 맞는 index 에 값(arr[i]) 넣기
            for (int i=0; i<arr.length; i++) {
                int digit = getDigitsByPosition(arr[i], pos);
                sortedArray[digit].add(arr[i]);
            }

            // 자리수 마다 추가된 값들을 원래 배열에 넣어줌
            int index = 0;
            for(int i=0; i<MAX_DIGIT; i++) {
                for (int j=0; j<sortedArray[i].size(); j++) {
                    arr[index++] = sortedArray[i].get(j);
                }
            }
        }
    }

    public int getDigitsByPosition(int value, int position) {
        return Character.getNumericValue(String.valueOf(value).charAt(position));
    }

    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        radixSort.solution();
    }
}
