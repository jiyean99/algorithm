package A6투포인터;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A01TwoPointerBasic {
    public static void main(String[] args) {
        // [📝실습예제] 아래의 배열에서 target이 될 수 있는 두 수의 조합을 모두 찾아내라
        // e.g (1, 9) = (9, 1)
        int[] arr = {7, 8, 9, 2, 4, 5, 1, 3, 6};

        int target = 10;

        List<int[]> myList = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    myList.add(new int[]{arr[i], arr[j]});
                }
            }
        }

        for (int[] a : myList) {
            System.out.println(Arrays.toString(a));
        }

        // 이 때 위 코드의 복잡도는 n^2이다.

        // 위 배열을 정렬한다고 가정 : 1, 2, 3, 4, 5, 6, 7, 8, 9 (정렬 복잡도 : n*log(n))
        // 이 때 합이 10인지 확인하기 위해서는 양 끝의 조합으로 가면 됨.
        // 1+9를 구해보고, 1+8을 구해보고, .. 이 떄 1+7을 봐야하나? 어짜피 이 때는 start를 옮길거라서 1+7을 탐색할 필요가 없는 것
        // 투포인터 풀이(그냥 외워라) : 정렬  -> 투포인터 공식
        System.out.println("====== 투포인터 풀이 ======");
        List<int[]> twoPointList = new ArrayList<>();
        Arrays.sort(arr);
        int start = 0;
        int end = arr.length - 1;

        while (start < end) { // 현재는 s가 e보다 작야아하는 로직
            int sum = arr[start] + arr[end];
            if (sum == target) {
                twoPointList.add(new int[]{start, end});
                start++;
            } else if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            }
        }

        for (int[] a : twoPointList){
            System.out.println(Arrays.toString(a));
        }
        // 위 코드의 복잡도 : 정렬의 복잡도(n*log(n)) + 투포인터 복잡도(n)
    }
}
