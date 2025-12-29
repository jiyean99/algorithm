package A2dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class A01Dfs방문순서 {
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        // 출발은 0부터 시작했을 때, dfs로 방문할 경우 방문 순서
//        int[][] nodes = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 4}};
        int[][] nodes = {{0, 1}, {2, 0}, {1, 3}, {2, 3}, {2, 4}}; // 이런 식으로 구조화하면 0에서 갈 수 있는 노드들을 선별하기 어렵기때문에 리스트로 두게 됨 -> 인접 리스트 자료구조로 설계한다
        visited = new boolean[nodes.length];

        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }
        // [[], [], [], [], []] :)

        // 양방향 간선인 경우
        for (int[] n : nodes) {
            /*
            int start = n[0];
            int end = n[1];
            adjList.get(start).add(end);
            adjList.get(end).add(start);
            */
            adjList.get(n[0]).add(n[1]);
            adjList.get(n[1]).add(n[0]);
        }
        // 정점의 번호가 작은것부터 방문하기 위한 정렬작업
        for (List<Integer> l : adjList) {
            l.sort(Comparator.naturalOrder());
        }
        // [[1, 2], [0, 3], [0, 3, 4], [1, 2], [2]]
        dfs(0);
    }

    static void dfs(int start) {
        System.out.println(start);
        visited[start] = true;
        for (int target : adjList.get(start)) {
            if (!visited[target]) {
                dfs(target);
            }
        }
    }
}
