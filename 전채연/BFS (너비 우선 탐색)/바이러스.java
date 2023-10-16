import java.io.*;
import java.util.*;

public class 바이러스 {
    static int result = 0;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); 

    static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        visited[1] = true;

        while (!que.isEmpty()) {
            int node = que.remove();

            for (int i = 0; i < graph.get(node).size(); i++) {
                int n = graph.get(node).get(i);

                // 이미 방문한 경우
                if (visited[n]) continue;

                visited[n] = true;
                que.add(n);
                result++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());
        int connection = Integer.parseInt(br.readLine());
        visited = new boolean[computer + 1];

        for (int i = 0; i <= computer; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < connection; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph.get(start).add(end);
            graph.get(end).add(start);
        }

        bfs();

        System.out.println(result);
    }
}
