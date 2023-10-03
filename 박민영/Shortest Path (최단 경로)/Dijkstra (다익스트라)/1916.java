/*
 * @author Minyeong Park
 * @date 2023.10.01.
 * 최소비용 구하기
 * 문제 링크 : https://www.acmicpc.net/problem/1916
 * 참고 : https://velog.io/@suk13574/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Java%EB%8B%A4%EC%9D%B5%EC%8A%A4%ED%8A%B8%EB%9D%BCDijkstra-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98, 
 *        https://steady-coding.tistory.com/84
 */


import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return cost - o.cost;
    }
}

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Node>> a = new ArrayList<>(); // 인접 리스트
    static int[] costs;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < n + 1; i++) {
            a.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            a.get(start).add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start, end);

        System.out.println(costs[end]);
    }

    static void dijkstra(int start, int end) {
        costs = new int[n + 1];
        visited = new boolean[n + 1];

        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.index;

            if (visited[now]) continue;
            visited[now] = true;

            // index의 연결된 정점 비교
            for (Node next : a.get(now)) {
                if (!visited[next.index] && costs[next.index] > costs[now] + next.cost) {
                    costs[next.index] = costs[now] + next.cost;
                    pq.offer(new Node(next.index, costs[next.index]));
                }
            }
        }
    }
}