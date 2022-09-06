// chap11 Q6. 무지의 먹방 라이브
// 내가 푼 풀이인데 정확성 테스트만 모두 통과하고 효율성 테스트는 통과하지 못해서.. 굉장히 깔끔하지 않은 풀이지만 일단 저장함...
// 해설 풀이를 보니 접근 방법부터 틀렸음...

class Solution {
    public int solution(int[] food_times, long k) {
        int now_food_idx = 0;
        for (int i = 0; i < k; i++) {
            // 일단 간단하게 먼저 구하기
            int count = 0;
            while (food_times[now_food_idx] <= 0) {
                now_food_idx++;
                count++;
                if (now_food_idx >= food_times.length) {
                    now_food_idx -= food_times.length;
                }
                if (count > food_times.length) {
                    break;
                }
            }
            if (food_times[now_food_idx] > 0) {
                food_times[now_food_idx]--;
            }

            now_food_idx++;
            if (now_food_idx >= food_times.length) {
                now_food_idx -= food_times.length;
            }
        }

        int count = 0;
        while (food_times[now_food_idx] <= 0) {
                now_food_idx++;
                count++;
                if (now_food_idx >= food_times.length) {
                    now_food_idx -= food_times.length;
                }
                if (count > food_times.length) {
                    break;
                }
        }

        boolean empty_flag = true;
        for (int i = 0; i < food_times.length; i++) {
            if (food_times[i] != 0) {
                empty_flag = false;
            }
        }

        if (empty_flag) {
            return -1;
        } else {
            return now_food_idx + 1;
        }
    }
}
