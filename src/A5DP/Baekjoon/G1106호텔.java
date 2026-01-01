package A5DP.Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G1106호텔 {
    public static void main(String[] args) throws IOException {
        // 최소 늘려야하는 고객 수가있고, 이 때 최소의 값을 지불하여 최소 고객 유치
        // c: 최소 늘려야하는 고객 수, n: 도시의 수
        // costByCity: 각 도시 비용, valueBtCity : 각 도시 효율(고객수)
        // 이 때 각 도시의 고객수는 무한

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] cityInfoArr = new int[n][2]; // 도시 수만큼의 {비용, 고객수}

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cityInfoArr[i][0] = Integer.parseInt(st.nextToken());
            cityInfoArr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 가격, 고객수
        // 3 5
        // 1 1

        // 가격 별 고객수를 담는 주머니
        // 1원일 때 고객수, 2원일 때 고객수, 3원일떄 고객수 ,,, 최대로 필요한 고객수 * 각 도시 유치비용 까지의 경우의 수를 발생시킬 수 있다

        int[] dp = new int[1000 * 100 + 1];

        for (int i = 0; i < dp.length; i++) {
            int cost = cityInfoArr[i][0];
            int value = cityInfoArr[i][1];
//            for (int j <= ; j < ; j++) {
//
//            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
