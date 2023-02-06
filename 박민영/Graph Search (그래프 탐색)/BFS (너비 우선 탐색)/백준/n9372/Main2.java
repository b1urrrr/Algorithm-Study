/*
 * @author Minyeong Park
 * @date 2023.02.04.
 * 상근이의 여행 (다른 풀이 공부)
 * 참고 : https://www.acmicpc.net/board/view/47197, https://www.acmicpc.net/board/view/38050, https://hidelookit.tistory.com/197
 *       https://velog.io/@dongvelop/%EC%8A%A4%ED%8C%A8%EB%8B%9D-%ED%8A%B8%EB%A6%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 * 문제 링크 : https://www.acmicpc.net/problem/9372
 */

/*
 * 스패닝 트리(신장 트리) : 그래프의 모든 정점을 잇지만 사이클이 없는 부분 그래프, 스패닝 트리는 그래프의 최소 연결 부분 그래프
 * -> 트리에서 모든 간선의 가중치가 같으면 이 스패닝 트리의 간선의 개수는 무조건 (노드 개수 - 1)
 *    n개의 정점을 가지는 그래프의 최소 간선의 수는 (n-1)개
 */

// 스패닝 트리

//


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            for (int j = 0; j <= n; j++) {
                list.add(new ArrayList<Integer>());
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.get(a).add(b);
                list.get(b).add(a);
            }

            System.out.println(n - 1);
        }
    }
}