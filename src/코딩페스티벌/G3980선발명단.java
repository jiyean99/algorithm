package 코딩페스티벌;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3980선발명단 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int[][] arr = new int[11][11];
            for (int j = 0; j < 11; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 11; k++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
        }
    }
}
