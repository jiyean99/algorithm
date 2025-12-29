package A1sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// <트리탐색 + 재귀적 호출>을 통한 힙 정렬
// 트리구조를 배열로 어떻게 표현하지? 자식노드를 어떻게 표현하지? 재귀호출을 어디서 하지? 이런 관점으로 바라봐야함
public class A01HeapSort구현 {
    public static void main(String[] args) {
        /// * ************ 0. 준비: 정렬이 되어있지 않은 배열 ************ *///
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};

        /// * ************ 1. 최초힙구성 ************ *///
        /// 1-1) 부모노드(전체노드/2)와 자식노드(전체노드/2) 분리 후 부모노드를 대상으로 heapify
        /// 1-2) 자식노드의 왼쪽 노드 : (부모노드 * 2 + 1), 오른쪽 노드 : (부모노드 * 2 + 2)
        /// 1-3) heapify 과정이 재귀호출로 이루어짐
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length); // i번재 인덱스가 두 자식 노드들보다 큰지, 작은지 따져야함(작지 않으면 자리 change)
        }

        System.out.println(Arrays.toString(arr));
        //int[] arr = {1, 3, 5, 6, 7, 5, 9, 8, 6}; // heapify 된 결과물(최초힙결과)

        /// * ************ 2. 루트노드와 최하위노드를 자리 change해가면서 재 heapify ************ *///
        /// 2-1) 자리 change한 마지막 노드는 heapify 대상에서 제외
        /// 2-2) 최소힙 -> 내림차순 정렬, 최대힙 -> 오름차순 정렬
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i]; //마지막자리값 감소(현재 for문 구조)
            arr[i] = temp;
            // 마지막노드는 heapify 대상에서 제외되어야함(전체길이는 계속 감소되어야함)
            // 무조건 0번째가 깨져있을테므로 부모인덱스는 0이 됨
            heapify(arr, 0, i); // arr, 부모인덱스, 전체길이(마지막노드는 빠져야하므로 i임)
        }

        System.out.println(Arrays.toString(arr));
        //int[] arr = {9, 8, 7, 6, 6, 5, 5, 3, 1}; // 최소힙

        /// * ************ pq를 통한 정렬 방법 -> 꺼낼때마다 정렬이 되는 것 ************ *///
        // * pq를 써야하는 상황 : pq를 가지고 직접 정렬을 수행하기보다는, 지속적으로 값을 add하고 poll해 나가는 상황에서 사용 (매번 정렬해줄필요가 없음)
        // * 최초힙 구성 복잡도 : n*log(n), 하나 add 할 때 log(n)이므로 n개 add하면 n*log(n)
        // * add 할 때 마다 복잡도 : log(n)
        // * poll 할 때 마다 복잡도 : log(n)
        Queue<Integer> pq = new PriorityQueue<>(Arrays.asList(7, 6, 5, 8, 3, 5, 9, 1, 6));
        System.out.println(pq);
        System.out.println(pq.poll());
        pq.add(2);
    }

    static void heapify(int[] arr, int parentIdx, int length) {
        // TODO 자식노드와의 비교 (이 때 반드시 길이체크를 선행해야 함)
        //  자식노드가 더 작으면 자리 change
        //  자리가 change된다면 재귀호출 수행(더 깊은곳까지 탐색해야해서)
        //  이 때 재귀호출 종료로직은 별도로 필요하지 않다

        // 가장 작은 인덱스값 찾기
        int leftIdx = parentIdx * 2 + 1;
        int rightIdx = parentIdx * 2 + 2;
        int smallestIdx = parentIdx;
        if (leftIdx < length && arr[leftIdx] < arr[smallestIdx]) {
            smallestIdx = leftIdx;
        }
        if (rightIdx < length && arr[rightIdx] < arr[smallestIdx]) {
            smallestIdx = rightIdx;
        }

        // 가장 작은 인덱스가 자식노드라면(부모노드가 아니라면), 자리 change 및 heapify 호출
        if (parentIdx != smallestIdx) {
            int temp = arr[parentIdx];
            arr[parentIdx] = arr[smallestIdx];
            arr[smallestIdx] = temp;
            heapify(arr, smallestIdx, length);
        }

    }

}
