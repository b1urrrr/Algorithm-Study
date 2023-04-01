/*
 * @author Minyeong Park
 * @date 2023.03.27.
 * 최소 스패닝 트리
 * 최소 신장 트리 원리 참고 : https://sskl660.tistory.com/72
 * 문제 링크 : https://www.acmicpc.net/problem/1197
 */


import java.io.*;
import java.util.*;

class Edge {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    static int v, e;
    static ArrayList<Edge> list;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        parent = new int[v + 1];
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new Edge(a, b, c));
        }

        // 그래프 데이터를 가중치 기준으로 정렬하기
        Collections.sort(list, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        // 부모 배열 자기 자신 인덱스로 초기화
        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        int weight_sum = 0;
        // 가중치가 낮은 엣지부터 연결 시도하기
        for (int i = 0; i < e; i++) {
            Edge now = list.get(i);
            if (find(now.start) == find(now.end))
                continue;

            union(now.start, now.end);
            weight_sum += now.weight;
        }
        System.out.println(weight_sum);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) {
            parent[a] = b;
        } else {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if (a == parent[a])
            return a;
        else {
            return find(parent[a]);
        }
    }
}