/*
 * @author Minyeong Park
 * @date 2022.08.02.
 * 프린터 큐
 * 참고 및 출처 : https://st-lab.tistory.com/201
 * 문제 링크 : https://www.acmicpc.net/problem/1966
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int n, m;
        LinkedList<int[]> queue;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                // {초기 위치, 중요도}
                queue.offer(new int[] {j, Integer.parseInt(st.nextToken())});
            }

            int count = 0; // 출력한 문서의 개수
            while (!queue.isEmpty()) {
                int[] front = queue.poll(); // 가장 원소
                boolean isMax = true; // front 원소가 가장 큰 원소인지를 판단하는 변수

                // 큐에 남아 있는 원소들과 중요도를 비교
                for (int j = 0; j < queue.size(); j++) {
                    if (front[1] < queue.get(j)[1]) {
                        // 뽑은 원소 및 i 이전의 원소들을 뒤로 보낸다.
                        queue.offer(front);
                        for (int k = 0; k < j; k++) {
                            queue.offer(queue.poll());
                        }
                        // front원소가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
                        isMax = false;
                        break;
                    }
                }

                // front 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
                if (isMax == false)
                    continue;

                // 이 아래로 내려오면 front 원소가 가장 큰 원소였으므로, 해당 원소는 출력해야 하는 문서이다.
                count++;
                if (front[0] == m) { // 찾고자 하는 문서라면 해당 테스트케이스 종료
                    break;
                }
            }

            System.out.println(count);
        }
    }
}