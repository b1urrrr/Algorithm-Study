/*
 * @author Minyeong Park
 * @date 2023.01.21.
 * 카드 (다른 풀이 공부)
 * 출처 : https://velog.io/@kimmjieun/%EB%B0%B1%EC%A4%80-11652%EB%B2%88-%EC%B9%B4%EB%93%9C-Java-%EC%9E%90%EB%B0%94
 * 문제 링크 : https://www.acmicpc.net/problem/17218
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1); // getOrDefault : map에 해당 키 값이 있으면 꺼내오고, 없으면 0을 반환한다. 키에 대한 밸류 값을 꺼내온 후 +1을 하는 방식으로 가야 한다!!
        }

        // map.value()로 만든 리스트를 for문을 이용해 가장 큰 value 구하기
        int max_cnt = 0;
        ArrayList<Integer> list = new ArrayList<>(map.values()); // value들만 들어간 ArrayList 생성
        for (Integer count : list) {
            max_cnt = Math.max(max_cnt, count);
        }

        // 가장 큰 value를 가진 key 값을 우선순위 큐에 넣기 (오름차순으로 수를 넣기 위함)
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (long key : map.keySet()) {
            if (max_cnt == map.get(key)) {
                q.add(key);
            }
        }

        // 큐에서 가장 앞에 있는 값을 출력
        System.out.println(q.poll());
    }
}