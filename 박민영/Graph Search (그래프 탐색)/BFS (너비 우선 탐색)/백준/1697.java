/*
 * @author Minyeong Park
 * @date 2023.03.17.
 * 숨바꼭질
 * 원리 및 코드 참고 : https://smartpro.tistory.com/18
 * 문제 링크 : https://www.acmicpc.net/problem/1697
 */



import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] visited = new int[100001];

        Queue<Integer> q = new LinkedList<>();

        q.offer(n);
        int index = n;
        visited[index] = 1;
        int num = 0;
        int result = 0;
        while (!q.isEmpty()) {
            num = q.poll();
            if (num == k) {
                result = visited[k] - 1; // 값을 0이 아닌 1부터 시작해서 1을 빼주어야 함
                break;
            }
            if (num - 1 >= 0 && visited[num - 1] == 0) { // 현재에서 -1 위치를 방문한 적이 없으면
                visited[num - 1] = visited[num] + 1; // 몇번만에 방문했는지를 현재 것에 +1해서 저장함
                q.offer(num - 1);
            }

            if (num + 1 <= 100000 && visited[num + 1] == 0) { // 현재에서 +1 위치를 방문한 적이 없으면
                visited[num + 1] = visited[num] + 1;
                q.offer(num + 1);
            }

            if (num * 2 <= 100000 && visited[num * 2] == 0) { // 현재에서 *2 위치를 방문한 적이 없으면
                visited[num * 2] = visited[num] + 1;
                q.offer(num * 2);
            }
        }
        System.out.println(result);
    }
}