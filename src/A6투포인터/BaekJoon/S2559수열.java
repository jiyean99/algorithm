package A6투포인터.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S2559수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 측정한 날짜 수
        int k = Integer.parseInt(st.nextToken()); // 연속적인 날짜 수

        int start = 0;
        int end = start + k - 1;

        int[] dayTemp = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dayTemp[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> list = new ArrayList<>();


    }
}
