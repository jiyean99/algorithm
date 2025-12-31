package A5DP;

import java.util.Arrays;

public class A02동전문제 {
    public static void main(String[] args) {
        // 그리디 변형해서 DP로 만듦
        // [📝실습예제] 1,4,5원의 동전이 있을 때, 조합하여 13을 만들 수 있는 최소의 개수
        // 그리디 : 5가 젤 크네? 5로 먼저 떼우고 나머지를 채우면 되겠네? -> 도달이 불가능함 (*그리디 예시의 경우는 배열의 요소들이 서로 다 나누어지는 값이였음)
        // DP는 어떻게 아이디어를 도출하나요? -> 현재 기준으로 봤을 때 과거의 값을 활용할 수 있을까? 그럼 DP로 접근하고 그로 사고하라
        // 현재 실습예제를 통한 사고 흐름:
        // 13을 어떻게 만들 수 있지? 13입장에서 13을 만들 수 잇는 경우는 단 3가지 경우 뿐이다.
        // (1) 12원에서 1원 더해서 만들기, (2) 9원에서 4원 더해서 만들기, (3) 8원에서 5원 더해서 만들기
        // 이 때 각 각 12원, 9원, 8원을 만드는 방법은 최소로 잘 구해놨다는 전제를 깔고 감

        int[] arr = {1, 4, 5};
        int target = 13;

        // n원을 만드는 최소 동전 수 : min(dp[n-a], dp[n-b], dp[n-c]) + 1
        int[] dp = new int[target + 1];

        for (int i = 1; i <= target; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < arr.length; j++) {
                if (i - arr[j] >= 0 && dp[i - arr[j]] < min) {
                    min = dp[i - arr[j]];
                }
            }
            dp[i] = min + 1;
        }

        System.out.println(Arrays.toString(dp));
    }

    // 동전2(2294) - 백준(https://www.acmicpc.net/problem/2294)
    // 1이 포함되지 않을수도 있고, target을 못 만들수도 있는 경우의 동전 문제
}
