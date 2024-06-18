package week_2.mgpark;

import java.util.List;
import week_2.mgpark.util.Argument;
import week_2.mgpark.util.ListUtils;

public class QuickSort {

  public static void main(String[] args) {
//    execute(new String[]{
//        "6",
//        "5 2 6 1 3 8"
//    });
    execute(new String[]{
        "6",
        "19 24 23 16 1 2"
    });
    execute(new String[]{
        "6",
        "195 25 5386 48 84 55"
    });
  }

  private static void execute(String[] args) {
    Argument argument = Argument.of(args);

    List<Integer> copiedList = ListUtils.copyAsNew(argument.arr());

    quickSort(copiedList, 0, argument.arrSize() - 1);

    ListUtils.print(copiedList);
  }

  private static void quickSort(List<Integer> copiedList, int start, int end) {
    if (start < end) {
      // arr pivot으로 정렬
      int pivot = sortByPivot(copiedList, start, end);

      // pivot 기준으로 반으로 나누어 재정렬
      quickSort(copiedList, start, pivot - 1);
      quickSort(copiedList, pivot + 1, end);
    }
  }

  private static int sortByPivot(List<Integer> arr, int start, int end) {
    int pivot = arr.get(end);
    int cursor = start-1;

    for (int j = start; j <= end; j++) {
      if (arr.get(j) < pivot) {
        cursor++;
        swap(arr, cursor, j);
      }
    }

    swap(arr, cursor + 1, end);
    return cursor + 1;
  }

  private static void swap(List<Integer> arr, int i, int j) {
    int temp = arr.get(i);
    arr.set(i, arr.get(j));
    arr.set(j, temp);
  }
}
