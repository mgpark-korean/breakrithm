package week_5.jhsong;

import java.util.ArrayDeque;

/*
    Queue:
        - 먼저 들어간 데이터가 가장 먼저 나오는 구조 (FIFO; First In First Out)
        - 시간복잡도 O(1)
        - 동작
            1. push: 데이터를 가장 뒤에 추가
            2. size: 데이터 수 반환
            3. empty: 데이터 존재 여부
            4. front: 가장 상단에 있는 데이터 반환 (제거 X)
            5. pop: 가장 상단에 있는 데이터 반환 및 제거
 */
public class Deque {
    public void guessDequePrintResult() {
        java.util.Deque<Integer> deque = new ArrayDeque<>();

        deque.addLast(15); // 15
        deque.addFirst(20); // 20 15
        deque.addLast(25); // 20 15 25
        deque.addLast(30); // 20 15 25 30

        System.out.println(deque.pollLast()); // 20 15 25, 30 출력
        System.out.println(deque.pollFirst()); // 15 25, 20 출력
        deque.addLast(27); // 15, 25, 27
        System.out.println(deque.size()); // size: 3
        System.out.println(deque.pollLast()); // 15 25 27 출력
        System.out.println(deque.pollFirst()); // 25 27, 15 출력
    }

    public void guessDequePrintResult2() {
        java.util.Deque<Integer> deque = new ArrayDeque<>();

        // 10
        deque.addLast(10); // 10
        printDeque(deque);

        // 20 10
        deque.addFirst(20); // 20 10
        printDeque(deque);

        // 20
        deque.pollLast(); // 10
        printDeque(deque);

        // (1)
        System.out.printf("(1): %d\n", deque.size()); // 3 출력
        // (2)
        System.out.printf("(2): %d\n", deque.peekFirst()); // 20 출력

        // [20, 17]
        deque.addLast(17);
        printDeque(deque);

        // [20, 17, 25]
        deque.addLast(25);
        printDeque(deque);

        // [20, 17, 25, 13]
        deque.addLast(13);
        printDeque(deque);

        // (3) [20, 17, 25, 13]
        System.out.printf("(3): %d\n", deque.pollLast()); // 13 출력
        printDeque(deque);

        // (4) [20, 17, 25], 20 출력을 위해 pollFirst() 호출
        System.out.printf("(4): %d\n", deque.pollFirst()); // 20 출력
        printDeque(deque);

        // (5)
        System.out.printf("(5): %d\n", deque.size()); // 3
        printDeque(deque);
    }

    public void printDeque(java.util.Deque<Integer> deque) {
        System.out.print("현재 deque: [");
        if (!deque.isEmpty()) {
            deque.forEach(v -> System.out.printf("%d, ", v));
        }
        System.out.print("]");
        System.out.println();

    }

    public void solution() {
//        guessDequePrintResult();

        guessDequePrintResult2();
    }

    public static void main(String[] args) {
        Deque deque = new Deque();

        deque.solution();
    }
}
