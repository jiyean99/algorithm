package A4greedy;

import java.util.Arrays;

//greedy(탐욕법) : 현재로서 최적의 해를 선택했을 때, 전체의 최적해를 보장하는 알고리즘.
// 매 선택 시점에서 가장 최적으로 보이는 선택을 하는 방식. 즉, 지역적으로 최적(local optimum)인 선택을 통해 전역적으로 최적(global optimum)인 결과를 도출
public class A01GreedyBasic {
    public static void main(String[] args) {
        // [📝실습예제] 1, 5, 10, 20원 짜리의 동전이 있을 때, 이를 조합하여 99를 만들 수 있는 조합 중에 최소개수를 구하라.
        int[] arr = {10, 5, 1, 20};
        int target = 99;
        int total = 0; // 최소값을 담는 변수

        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            int a = arr[i];
            int b = target / a; // 몫
            total += b;
            target -= b * a;
        }


        System.out.println(total);
    }
}
