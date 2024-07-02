package week_3.jhsong;

public class HeapSort {
    int [] arr = {0, 5, 7, 9, 4, 3, 8, 6};
    public void solution() {
        // 배열의 갯수 / 2 번째 원소부터 거꾸로 1번째 원소까지 heapify 과정 거침
        // 7 개 -> 3번째 원소
        // heapify: 현재 노드 기준으로 heap 특성에 맞을 때 까지 계속 밑으로 내려주는 과정

        heapSort();

        for(int i = 1; i <= arr.length -1; i++)
            System.out.print(arr[i] + " ");
    }

    public void heapify(int num, int depth) {
        // largest 노드가 자식 노드 인 경우 swap
        // arr[depth]: 현재 노드
        // arr[depth * 2]: 좌측 노드
        // arr[depth * 2 + 1]: 우측 노드
        int largest = depth;
        int left = depth * 2;
        int right = depth * 2 + 1;

        if (left <= num && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right <= num && arr[right] > arr[largest]) {
            largest = right;
        }

        // 현재 노드가 자식 노드와 다른 경우 swap
        if (largest != depth) {
            int temp = arr[depth];
            arr[depth] = arr[largest];
            arr[largest] = temp;

            heapify(num, largest);
        }
    }

    public void heapSort() {
        int numCount = arr.length -1;
        int depth = numCount / 2;

        // max heap 만들기
        for (int i=depth; i>=1 ; i--) {
            heapify(numCount, i);
        }

        // 정렬
        for (int i=numCount; i>1; i--) {
            int temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;

            heapify(i - 1, 1);
        }
    }

    // 부모 노드가 자식 노드가 갖는 값보다 같거나 큰 경우를 만족 (max-heap)
    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        heapSort.solution();
    }
}
