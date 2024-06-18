package week_2.mgpark.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {


  /**
   * 리스트를 새로 생성한다.
   *
   * @param list 복사할 리스트.
   * @return 복사된 리스트.
   */
  public static List<Integer> copyAsNew(List<Integer> list) {
    return new ArrayList<>(list);
  }

  /**
   * <p>리스트를 출력한다.</p>
   * <p>ex) 1 2 3 4 5</p>
   *
   * @param list 출력할 리스트.
   */
  public static void print(List<Integer> list) {
    System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(" ")));
  }
}
