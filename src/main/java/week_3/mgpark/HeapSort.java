package week_3.mgpark;

import java.util.ArrayList;
import java.util.List;
import week_2.mgpark.util.ListUtils;
import week_3.mgpark.util.Argument;

public class HeapSort {

  public static void main(String[] args) {
    execute(new String[]{
        "6",
        "5 2 6 1 3 8"
    });
  }

  public static void execute(String[] args) {
    Argument argument = Argument.of(args);

    List<Integer> sortedList = heapSort(argument);

    ListUtils.print(sortedList);
  }

  private static List<Integer> heapSort(Argument args) {
    List<Integer> list = new ArrayList<>();
    list.add(null);
    list.addAll(args.arr());

    int limitSize = list.size() / 2; // 최초 heap 구성시 하위 노드는 수행할 필요 없음으로 node 수 / 2

    // 최초 heap 구성
    for (int i = limitSize; i > 0; i--) {
      heapify(list, i, args.arrSize());
    }

    for (int i = args.arrSize(); i > 1; i--) {
      int temp = list.get(i);
      list.set(i, list.get(1));
      list.set(1, temp);

      heapify(list, 1, i - 1);
    }

    return list;
  }

  private static void heapify(List<Integer> list, int rootNodeNo, int leafNodeNo) {
    int largestIndex = rootNodeNo;
    int leftNodeIndex = rootNodeNo * 2;
    int rightNodeIndex = rootNodeNo * 2 + 1;

    if (leftNodeIndex <= leafNodeNo && list.get(largestIndex) < list.get(leafNodeNo)) {
      largestIndex = leftNodeIndex;
    }

    if(rightNodeIndex <= leafNodeNo && list.get(largestIndex) < list.get(rightNodeIndex)) {
      largestIndex = rightNodeIndex;
    }

    if (largestIndex != rootNodeNo) {
      int temp = list.get(rootNodeNo);
      list.set(rootNodeNo, list.get(largestIndex));
      list.set(largestIndex, temp);
      heapify(list, largestIndex, leafNodeNo);
    }
  }
}
