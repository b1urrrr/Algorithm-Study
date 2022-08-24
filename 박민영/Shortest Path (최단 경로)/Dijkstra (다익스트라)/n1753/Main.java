/*
 * @author Minyeong Park
 * @date 2022.07.23.
 * 최단경로
 * 참고 : https://github.com/b1urrrr/Algorithm-Study/blob/main/%EB%B0%95%EB%AF%BC%EC%98%81/%EA%B5%90%EC%9E%AC%20%EC%98%88%EC%A0%9C/%EC%9D%B4%EA%B2%83%EC%9D%B4%20%EC%BD%94%EB%94%A9%20%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%8B%A4/chap09/n9_2.java
 * 문제 링크 : https://www.acmicpc.net/problem/1753
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    private int index;
    private int weight;

    public Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    public int getIndex() {
        return index;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Node o) {
        if (this.weight < o.weight) {
            return -1;
        }
        return 1;
    }
}

public class Main {
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static int[] d = new int[20001]; // 거리
    static int v, e, start;
    static int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        // 그래프 초기화
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, w));
        }

        // 최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        dijkstra(start);

        for (int i = 1; i <= v; i++) {
            if (d[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(d[i]);
            }
        }
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int cur_idx = node.getIndex();
            int cur_weight = node.getWeight();

            if (d[cur_idx] < cur_weight) continue; // 현재 노드가 이미 처리된 적이 있는 노드라면 무시

            // 현재 노드와 인접한 다른 노드들을 확인
            for (int i = 0; i < graph.get(cur_idx).size(); i++) {
                int cost = d[cur_idx] + graph.get(cur_idx).get(i).getWeight(); // 현재 노드까지의 거리 + 현재 노드에서 i번째 다른 노드까지의 거리

                // 현재 노드를 거쳐서 다른 노드로 이동하는 거리가, 이미 저장된 다른 노드의 거리보다 더 짧은 경우
                if (cost < d[graph.get(cur_idx).get(i).getIndex()]) {
                    d[graph.get(cur_idx).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(cur_idx).get(i).getIndex(), cost));
                }
            }
        }
    }
}