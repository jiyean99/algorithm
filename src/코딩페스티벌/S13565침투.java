package 코딩페스티벌;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S13565침투 {
    static int M, N;
    static int[][] grid;
    static boolean[][] visited;
    static boolean isPercolates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        grid = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) grid[i][j] = str.charAt(j) - '0';
        }

        for (int j = 0; j < N; j++) {
            if (grid[0][j] == 0 && !visited[0][j]) {
                dfs(0, j);
            }
            if (isPercolates) break;
        }

        System.out.println(isPercolates ? "YES" : "NO");
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        if (x == M - 1) {
            isPercolates = true;
            return;
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (0 <= nx && nx < M && 0 <= ny && ny < N && !visited[nx][ny] && grid[nx][ny] == 0) {
                dfs(nx, ny);
            }
        }
    }

}
