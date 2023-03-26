/*
 * @author Minyeong Park
 * @date 2023.03.24.
 * 거짓말
 * 문제 링크 : https://www.acmicpc.net/problem/1043
 */


import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int know_person_cnt = Integer.parseInt(st.nextToken());
        boolean[] know_people = new boolean[n + 1];
        for (int i = 0; i < know_person_cnt; i++) {
            know_people[Integer.parseInt(st.nextToken())] = true;
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        HashSet<Integer>[] parties = new HashSet[m + 1];
        for (int i = 1; i <= m; i++) {
            parties[i] = new HashSet<>();
        }

        for (int t = 1; t <= m; t++) {
            String[] inputs = br.readLine().split(" ");
            int person_cnt = Integer.parseInt(inputs[0]);
            if (person_cnt <= 1) {
                parties[t].add(Integer.parseInt(inputs[1]));
                continue;
            }
            for (int j = 1; j < person_cnt; j++) {
                int a = Integer.parseInt(inputs[j]);
                int b = Integer.parseInt(inputs[j+1]);
                if (find(a) != find(b))
                    union(a,b);

                parties[t].add(a); // 파티 참여하는 사람 저장
                parties[t].add(b);
            }
        }

        // 진실을 아는 사람과 같은 파티인 경우 진실을 아는 사람으로 판별
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (know_people[i] && !visited[i]) {
                int root = find(i);
                for (int j = 1; j <= n; j++) {
                    if (find(j) == root) {
                        know_people[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        // 모든 파티 참석자가 F 여야 과장된 이야기 가능
        int result = 0;
        for (int i = 1; i <= m; i++) {
            boolean flag = false;
            for (int person : parties[i]) {
                if (know_people[person]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) result++;
        }
        System.out.println(result);
    }

    static int find(int node) {
        if (parent[node] == node) {
            return node;
        }

        return parent[node] = find(parent[node]);
    }

    static void union(int a, int b) {
        parent[find(b)] = a; // b의 parent를 a로 변경
    }
}