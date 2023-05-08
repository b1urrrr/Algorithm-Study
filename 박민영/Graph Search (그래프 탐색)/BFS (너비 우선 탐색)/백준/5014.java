/*
 * @author Minyeong Park
 * @date 2023.05.07.
 * 스타트링크
 * 문제 링크 : https://www.acmicpc.net/problem/5014
 */


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());
        int u = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[f + 1];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(s, 0));
        visited[s] = true;
        boolean success = false;
        int result_count = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.floor == g) {
                success = true;
                result_count = now.count;
                break;
            }

            if (now.floor + u <= f && !visited[now.floor + u]) {
                q.offer(new Node(now.floor + u, now.count + 1));
                visited[now.floor + u] = true;

            }
            if (now.floor - d >= 1 && !visited[now.floor - d]) {
                q.offer(new Node(now.floor - d, now.count + 1));
                visited[now.floor - d] = true;
            }
        }

        if (success) {
            System.out.println(result_count);
        } else {
            System.out.println("use the stairs");
        }
    }
}

class Node {
    int floor;
    int count;

    public Node(int floor, int count) {
        this.floor = floor;
        this.count = count;
    }
}