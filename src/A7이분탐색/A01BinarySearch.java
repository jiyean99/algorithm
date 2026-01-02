package A7이분탐색;

public class A01BinarySearch {
    public static void main(String[] args) {
        // 이분탐색은 사전에 정렬된 데이터를 대상으로 log(n)의 복잡도의 검색을 수행하는 알고리즘
        // [📝실습예제] target의 인덱스 번호(위치)를 찾아라
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 17;
        // start, end index를 두고 mid 계산. (start+end/2) = answer
        // mid의 값이 target보다 클 때 : end = mid-1
        // mid의 값이 target보다 작을 때 : start = mid+1
        // mid의 값이 target보다 일치할 때 : answer = mid; break;

        int startIdx = 0;
        int endIdx = arr.length - 1;
        int targetIdx = -1;

        while (startIdx <= endIdx){ // TODO start와 end 인덱스가 역전되지 않도록 주의
            int mid = (startIdx + endIdx) / 2;

            if (arr[mid] > target) {
                endIdx = mid - 1;
            } else if (arr[mid] < target) {
                startIdx = mid + 1;
            } else {
                targetIdx = mid;
                break;
            }
        }

        System.out.println(targetIdx);


        // [📝실습예제 - 응용] target2가 arr에 있다면 index값을 리턴하고, arr에 없다면 있어야할 자리 index를 리턴한다
        // answer가 == 일 때 뿐만 아니라 <,> 일 때도 될 수 있음(상황에 따라 다름)
        int target2 = 4;

        int startIdx2 = 0;
        int endIdx2 = arr.length - 1;
        int targetIdx2 = -1;

        while (startIdx2 <= endIdx2){
            int mid = (startIdx2 + endIdx2) / 2;

            if (arr[mid] > target2) {
                endIdx2 = mid - 1;
                targetIdx2 = mid;
            } else if (arr[mid] < target2) {
                startIdx2 = mid + 1;
            } else {
                targetIdx2 = mid;
                break;
            }
        }

        System.out.println(targetIdx2);
    }
}
