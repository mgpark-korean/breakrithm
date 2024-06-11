package week_1.jhsong;

import week_1.jhsong.constant.Functions;
import week_1.jhsong.vo.Command;

import java.util.ArrayList;
import java.util.Scanner;

public class DynamicArray {
    // 동적 배열 생성
    ArrayList<Integer> dynamicArray = new ArrayList<>();

    public void solution() {
        ArrayList<Command> commands = readCommands();

        for (Command command: commands) {
            String function = command.getFunction();
            Integer number = command.getNumber();

            // 명령어 분기
            if (Functions.PUSH_BACK.name().equals(function)) {
                pushBack(number);
            } else if (Functions.POP_BACK.name().equals(function)) {
                popBack();
            } else if (Functions.SIZE.name().equals(function)) {
                size();
            } else if (Functions.GET.name().equals(function)) {
                get(number);
            }
        }
    }

    public ArrayList<Command> readCommands() {
        Scanner in = new Scanner(System.in);

        // System.out.println("명령어 수를 입력하세요.");
        int count = in.nextInt();
        in.nextLine();

        // 입력 받은 명령어들
        ArrayList<Command> commands = new ArrayList<>();
        // System.out.println(count + "개 명령어를 입력해주세요.\n");
        for (int i = 0; i < count; i++) {
            // 입력 받기
            String[] lineSplitTexts = in.nextLine().split(" ");

            // 명령어
            String function = lineSplitTexts[0].toUpperCase();
            Integer number = null;
            if (lineSplitTexts.length > 1) {
                number = Integer.parseInt(lineSplitTexts[1]);
            }

            commands.add(new Command(function, number));
        }

        return commands;
    }
    public void pushBack(Integer number) {
        if (number == null) {
            return;
        }

        dynamicArray.add(number);
    }

    public void popBack() {
        if (!dynamicArray.isEmpty()) {
            dynamicArray.remove(dynamicArray.size() - 1);
        }
    }

    public void size() {
        System.out.println(dynamicArray.size());
    }

    public void get(Integer index) {
        if (!dynamicArray.isEmpty()) {
            try {
                System.out.println(dynamicArray.get(index - 1));
            } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                System.err.println("없는 index 입니다.");
            }

        }
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.solution();
    }
}
