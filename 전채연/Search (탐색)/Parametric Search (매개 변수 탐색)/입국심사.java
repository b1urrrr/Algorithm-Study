/*
    프로그래머스 > 이분탐색 : 입국심사
    - 문제 유형 : 이분 탐색, 매개 변수 탐색
*/

class 입국심사 {
    // 매개변수 : 심사를 기다리는 사람 n, 심사관의 심사 시간 times
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long start = 1;
        long end = 1000000000000000000L;
        // 매개 변수 탐색
        while (start <= end) {
            long mid = (start + end) / 2;
            long total = 0;
            // mid 동안 심사할 수 있는 사람의 수 total에 저장
            for (int i = 0; i < times.length; i++) {
                total += mid / times[i];
            }
            
            // n명에 대해 심사 시간이 부족하면 시간 증가
            if (total < n) start = mid + 1;
            // n명에 대해 심사 시간이 충분하면 시간 감소
            else {
                answer = Math.min(mid, answer);
                end = mid - 1;
            }
        }
        
        // 모든 사람이 심사를 받는데 걸리는 시간의 최솟값 반환
        return answer;
    }
}