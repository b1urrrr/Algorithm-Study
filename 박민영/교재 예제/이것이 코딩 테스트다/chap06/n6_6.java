// chap06 (1) 계수 정렬 소스 코드

public class n6_6 {
    public static final int MAX_VALUE = 9;
    public static void main(String[] args) {
        int n = 15;
        // 모든 원소의 값이 0보다 크거나 같다고 가정
        int[] arr = {7,5,9,0,3,1,6,2,9,1,4,8,0,5,2};
        // 모든 범위를 포함하는 배열 선언
        int[] cnt = new int[MAX_VALUE + 1];

        for (int i = 0; i < n; i++) {
            cnt[arr[i]] += 1; // 각 데이터에 해당하는 인덱스 값 증가
        }

        for (int i = 0; i <= MAX_VALUE; i++) { // 배열에 기록된 정렬 정보 확인
            for (int j = 0; j < cnt[i]; j++)
                System.out.print(i + " ");
        }
    }
}
