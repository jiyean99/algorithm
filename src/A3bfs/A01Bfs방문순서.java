package A3bfs;

import java.util.*;

public class A01Bfs방문순서 {
    static List<List<Integer>> adjList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        int[][] nodes = {{0, 1}, {2, 0}, {1, 3}, {2, 3}, {2, 4}};
        visited = new boolean[nodes.length];

        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] n : nodes) {
            adjList.get(n[0]).add(n[1]);
            adjList.get(n[1]).add(n[0]);
        }
        for (List<Integer> l : adjList) {
            l.sort(Comparator.naturalOrder());
        }

        Queue<Integer> myQue = new LinkedList<>();
        myQue.add(0);
        visited[0] = true;
        while (!myQue.isEmpty()) {
            int temp = myQue.poll();
            // TODO 방문처리 위치 (1) : 꺼내는 시점에 방문처리할것이냐 -> 방문처리가 안되는 노드들이 발생함
            //visited[temp] = true;
            System.out.println(temp);
            for (int a : adjList.get(temp)) {
                if (!visited[a]) {
                    myQue.add(a);
                    // TODO 방문처리 위치 (2) : 큐에 담을 때 방문처리를 할 것이냐 (이게 맞다)
                    // 즉, bfs에서 visited는 queue에 add하는 시점에 true 세팅해야함
                    visited[a] = true;
                }
            }
        }
    }
}
