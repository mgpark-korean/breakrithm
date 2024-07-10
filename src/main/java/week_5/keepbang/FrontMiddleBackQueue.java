package week_5.keepbang;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/design-front-middle-back-queue/description/
 */
public class FrontMiddleBackQueue {

  List<Integer> q;

  public FrontMiddleBackQueue() {
    q = new LinkedList<>();
  }

  // 첫번째 인덱스에 값 추가
  public void pushFront(int val) {
    q.add(0, val);
  }

  // 중간 인덱스에 값 추가
  public void pushMiddle(int val) {
    int middleIndex = q.size() / 2;
    q.add(middleIndex, val);
  }

  // 마지막 인덱스에 값 추가
  public void pushBack(int val) {
    q.add(val);
  }

  public int popFront() {
    if (q.isEmpty()) return -1;
    return q.remove(0);
  }

  public int popMiddle() {
    if (q.isEmpty()) return -1;
    int middleIndex = q.size() / 2;
    return q.remove(middleIndex);
  }

  public int popBack() {
    if (q.isEmpty()) return -1;
    return q.remove(q.size() - 1);
  }
}
