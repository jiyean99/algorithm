package A3bfs;

import java.util.*;

public class A02Bfs최단거리 {
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        int[][] nodes = {{0, 1}, {2, 0}, {1, 3}, {2, 3}, {2, 4}};
        visited = new boolean[nodes.length];

        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }

        // 요구사항 : 0부터 target까지 가는 최단거리
        int target = 4;
        for (int[] n : nodes) {
            adjList.get(n[0]).add(n[1]);
            adjList.get(n[1]).add(n[0]);
        }
        for (List<Integer> l : adjList) {
            l.sort(Comparator.naturalOrder());
        }

        Queue<int[]> myQue = new LinkedList<>();
        // cf) 전혀다른 풀이 - distance 배열을 만들어서 각 노드마다 모든 거리를 다 기록해버린다. 이 때 distance[temp] + 1로 기록해주면 됨
        myQue.add(new int[]{0, 0}); // int[] 안에는 노드번호, 거리(root로부터)를 달고 다님 : {노드번호, 거리}
        visited[0] = true;
        int answer = -1;
        loop1:
        while (!myQue.isEmpty()) {
            int[] temp = myQue.poll();
            /* TODO 방법(1)
            if (temp[0] == target) {
                answer = temp[1];
                break;
            }
            */
            for (int a : adjList.get(temp[0])) {
                if (!visited[a]) {
                    myQue.add(new int[]{a, temp[1] + 1});
                    visited[a] = true;
                    // TODO 방법(2) -> 꺼내보기 전에 종료시킬 수 있어서 시간초과 대응 가능
                    if(target == a){
                        answer = temp[1] + 1;
                        break loop1;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
