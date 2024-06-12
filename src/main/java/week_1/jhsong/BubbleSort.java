package week_1.jhsong;

import java.util.Scanner;

public class BubbleSort {

    public void solution() {
        int [] numbers = readNumbers();
        bubbleSort(numbers);
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

    public void bubbleSort(int [] numbers) {
        int size = numbers.length;
        boolean sorted;

        do {
            sorted = true;
            for (int i=0; i<size-1; i++) {
                if (numbers[i] > numbers[i+1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i+1];
                    numbers[i+1] = temp;

                    sorted = false;
                }
            }
        } while (!sorted);

        for (int number: numbers) {
            System.out.print(number + " ");
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.solution();
    }
}
