package A2dfs;

public class A02이차원배열의완전탐색 {

    public static void main(String[] args) {
        // 일반적으로 2차원의 지도는 2차원 배열 형태로 주어짐
        // 갈 수 있는 곳, 갈 수 없는 곳, 출발지, 도착지 등이 숫자갓ㅂ으로 구분됨
        int[][] arr = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 2, 1},
                {1, 1, 1, 1}
        };
        int[] current = {0, 0};
        dfs(arr, current);
    }

    static void dfs(int[][] arr, int[] current) {
        // 가능 방법은 일반적으로 "상, 하, 좌, 우"로 주어지거나, 대각선까지 추가되는 경우가 있다.
        // 위로 이동 : {x - 1, y}
        // 아래로 이동 : {x + 1, y}
        // 좌로 이동 : {x, y - 1}
        // 우로 이동 : {x, y + 1}
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        for (int k = 0; k < 4; k++) {
            int nx = current[0] + dx[k];
            int ny = current[1] + dy[k];
            if (nx >= 0 && ny >= 0 && nx < arr[0].length && ny < arr[1].length) {
                dfs(arr, new int[]{nx, ny});
            }
        }
    }
    // 관련 문제 풀이 : 백준 - 숫자판점프
}
