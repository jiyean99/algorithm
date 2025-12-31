package A4greedy.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S1449수리공항승 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 구멍 수
        int l = Integer.parseInt(st.nextToken()); // 테이프 길이


        int[] spotArr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            spotArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(spotArr);

        // 배열에 구멍위치들을 담고 오름차순 정렬을 한다.
        // 첫번째 테이프 칠했을 때 몇번째 구멍까지 커버가 되는지 확인한다.
        // 몇번째 구멍까지 커버 되는지 어떻게 확인하나?
        // 커버 시작위치부터 테이프 길이까지를 가산하고, 가산된 길이 위치가 다음 구멍위치들이 있으면 거기까지 막고, list에서 구멍들을 뺀다.

        int count = 0;
//        while ()


        System.out.println(Arrays.toString(spotArr));
    }

}
