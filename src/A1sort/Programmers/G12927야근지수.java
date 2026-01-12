package A1sort.Programmers;

import java.util.*;

public class G12927야근지수 {
    public static void main(String[] args) {
        int[] works = {4, 3, 3};
        int n = 4;

        System.out.println(solution12927(n, works));
    }

    public static long solution12927(int n, int[] works) {
        // n: 앞으로 야근할 수 있는 총 시간(= 총 n번의 “-1 작업”을 할 수 있음).
        // works[i]: i번째 작업의 남은 작업량(정수).
        // 1시간에 할 수 있는 일: works 중 하나를 골라서 1만큼 감소시키는 것(0 밑으로는 내려가면 안 됨).
        // 이 때 works 중 가장 큰 값을 빼서 -1 하고 넣어주고, 또 가장 큰 값을 빼서 -1해서 넣어주고... 할 수 있는 시간만큼 다 균등하게 빼줌
        long answer = 0;
//        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        int totalWork = 0;
//        for (int i = 0; i < works.length; i++) {
//            pq.add(works[i]);
//            totalWork += works[i];
//        }
//
//        if(totalWork < n){
//            return 0;
//        }
//
//        for (int i = 0; i < n; i++) {
//            int change = pq.peek() - 1;
//            pq.poll();
//            pq.add(change);
//        }
//        while (!pq.isEmpty()) {
//            answer += (long) pq.peek() * pq.poll();
//        }
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        for (int i = 0; i < n; i++) {
            if (!pq.isEmpty()) {
                int max = pq.peek()- 1;
                pq.poll();
                pq.add(max );
            } else {
                answer = 0;
            }
        }

        for (int a : pq) answer += (long) a * a;

        return answer;
    }
}
