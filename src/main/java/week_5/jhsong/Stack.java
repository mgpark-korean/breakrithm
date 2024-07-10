package week_5.jhsong;

/*
    Stack:
        - 데이터가 들어가고 나오는 곳이 같은 자료 구조.
        - 나중에 들어간 값이 가장 먼저 나옴 후입선출 구조 (LIFO; Last In First Out)
        - 시간복잡도 O(1)
        - 동작
            1. push: 데이터를 가장 상단에 추가
            2. size: 데이터 수 반환
            3. empty: 데이터 존재 여부
            4. top: 가장 상단에 있는 데이터 반환 (제거 X)
            5. pop: 가장 상단에 있는 데이터 반환 및 제거
 */
public class Stack {
    public void guessStackPrintResult() {
        java.util.Stack<Integer> stack = new java.util.Stack<>();

        stack.push(15);
        stack.push(20);
        stack.push(35);
        stack.push(20);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.peek()); // Java 에서 구현된 Stack 에서는 top 과 동일한 액션을 하는 것이 peek
        System.out.println(stack.pop());
    }

    public boolean isClosedBrackets(String brackets) {
        java.util.Stack<Character> stack = new java.util.Stack<>();

        System.out.println(brackets);
        for (int i=0; i<brackets.length(); i++) {
            System.out.printf("%d 번째 값: '%s', 스택: ", i+1, brackets.charAt(i));
            if (brackets.charAt(i) == '(') {
                // (1)
                stack.push('(');
//                System.out.print("(");

            } else {
                if (stack.isEmpty()) {
                    System.out.printf("'%s'\n",brackets.charAt(i));

                    return false;
                }

                // (2)
                stack.pop();
            }

            stack.forEach(v -> System.out.printf("%s ", v));
            System.out.println();
        }

        System.out.println();

        if (!stack.isEmpty()) {
            System.out.println("스택에 값이 남아있음: ");
            stack.forEach(v -> System.out.printf("%s ", v));
            System.out.println();
            // (3)
            return false;
        }

        // (4)
        return true;
    }

    public void bracketString() {
        // 문제 10
        String brackets1 = "(()(())";
        System.out.println("결과 1: " + (isClosedBrackets(brackets1) ? "Yes" : "No"));
        System.out.println();

        String brackets2 = "(((()())()";
        System.out.println("결과 2: " + (isClosedBrackets(brackets2) ? "Yes" : "No"));
        System.out.println();

        String brackets3 = "((()()(()))(((())))()";
        System.out.println("결과 3: " + (isClosedBrackets(brackets3) ? "Yes" : "No"));
        System.out.println();

        String brackets4 = "()()()()(()()())()";
        System.out.println("결과 4: " + (isClosedBrackets(brackets4) ? "Yes" : "No"));
        System.out.println();
    }

    public void solution() {
        // 스택 값 출력 예상
//        guessStackPrintResult();

        // 괄호 문자열
        bracketString();

    }


    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.solution();
    }
}
