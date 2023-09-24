/*
    프로그래머스 > 2019 KAKAO BLIND RECRUITMENT : 무지의 먹방 라이브
    - 문제 유형 : 그리디
*/

import java.util.*;

public class 무지의_먹방_라이브 {
    class Food implements Comparable<Food> {
        int time;
        int index;
        
        public Food(int index, int time) {
            this.time = time;
            this.index = index;
        }
        
        @Override
        public int compareTo(Food other) {
            return Integer.compare(this.time, other.time);
        }
    }
    
    public int solution(int[] food_times, long k) {
        PriorityQueue<Food> pq = new PriorityQueue<>();
        long count = 0; // 모든 음식을 섭취하는 데 걸리는 시간
            
        // 큐에 음식 리스트 추가
        for (int i = 0; i < food_times.length; i++) {
            pq.add(new Food(i + 1, food_times[i]));
            count += food_times[i];
        }
        
        // 방송 중단 전에 음식을 모두 섭취하는 경우 -1 반환
        if (count <= k) return -1;
        
        long time = k; // 방송 중단까지 남은 시간
        int eaten = 0; // 직전에 다 먹은 음식의 개수
        long food = food_times.length; // 남은 음식의 개수
        
        // 섭취 시간이 적은 음식부터 큐에서 반환
        while ((pq.peek().time - eaten) * food <= time) {
            time -= (pq.peek().time - eaten) * food;
            eaten = pq.peek().time;
            pq.remove();
            food--;
        }
        
        // 우선순위 큐를 리스트로 변환
        ArrayList<Food> result = new ArrayList<>();
        for (int i = 0; i < food; i++) {
            result.add(pq.remove());
        }
        
        // 음식 번호 오름차순으로 리스트 정렬
        Collections.sort(result, new Comparator<Food>() {
            @Override
            public int compare(Food a, Food b) {
                return Integer.compare(a.index, b.index);
            }
        });
        
        return result.get((int) (time % food)).index;
    }
}