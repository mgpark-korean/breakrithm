package week_1.jhsong;

import java.util.Scanner;

public class SelectionSort {

    public void solution() {
        int [] numbers = readNumbers();
        selectionSort(numbers);
    }

    public int[] readNumbers () {
        Scanner scanner = new Scanner(System.in);

        // 입력 받을 숫자 갯수
        int count = scanner.nextInt();
        if (count < 0 || count > 100) {
            System.err.println("입력할 숫자 수는 1~100 사이여야 합니다.");
            System.exit(1);
        }

        // 정렬할 숫자
        int [] numbers = new int [count];
        for (int i=0; i<count; i++) {
            int number = scanner.nextInt();
            if (number < 0 || number > 100) {
                System.err.println("배열에 들어갈 수는 1~100 까지만 가능합니다.");
                System.exit(1);
            }

            numbers[i] = number;
        }

        return numbers;
    }

    public void selectionSort(int [] numbers) {
        int size = numbers.length;

        for (int i=0; i<size-1; i++) {
            int minIndex = i;

            // 값이 가장 작은 index 를 찾음 (minIndex)
            for (int j=i+1; j<size; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }

            // i 의 값과 minIndex 값을 변경
            int temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
        }

        for (int number: numbers) {
            System.out.print(number + " ");
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.solution();
    }
}
