package week_1.mgpark;

import java.util.ArrayList;
import java.util.Objects;

public class DynamicArray {
  public static void main(String[] args) {
    int commandCount = Integer.parseInt(args[0]);
    ArrayList<Integer> results = new ArrayList<>();

    for (int i = 1; i <= commandCount; i++) {
      CommandArg commandArg = CommandArg.of(args[i]);

      switch (commandArg.keyword) {
        case PUSH_BACK -> results.add(commandArg.number);
        case POP_BACK -> results.removeLast();
        case SIZE -> System.out.println(results.size());
        case GET -> System.out.println(results.get(commandArg.number - 1));
      }
    }
  }

  /**
   * 명령어 Enum.
   */
  private enum CommandKeyword {
    PUSH_BACK("push_back"),
    POP_BACK("pop_back"),
    SIZE("size"),
    GET("get");

    private final String name;

    CommandKeyword(String name) {
      this.name = name;
    }

    public String getName() {
      return this.name;
    }

    public static CommandKeyword getByName(String commandName) {
      for (CommandKeyword commandKeyword : CommandKeyword.values()) {
        if (Objects.equals(commandKeyword.getName(), commandName)) {
          return commandKeyword;
        }
      }

      return null;
    }
  }

  /**
   * 명령어 argument.
   *
   * @param keyword {@link CommandKeyword}
   * @param number  숫자.
   */
  private record CommandArg(
      CommandKeyword keyword,
      Integer number
  ) {

    public static CommandArg of(String arg) {
      String[] splitArg = arg.split(" ");

      CommandKeyword keyword = CommandKeyword.getByName(splitArg[0]);
      Integer number =
          splitArg.length > 1 ? Integer.parseInt(splitArg[1]) : null;

      return new CommandArg(keyword, number);
    }

  }
}
