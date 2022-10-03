// chap13 Q19.연산자 끼워 넣기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class n13_19 {
    public static int n;
    // 연산을 수행하고자 하는 수 리스트
    public static ArrayList<Integer> arr = new ArrayList<>();
    // 더하기, 빼기, 곱하기, 나누기 연산자 개수
    public static int add, sub, mul, divi;

    // 최솟값과 최댓값 초기화
    public static int minValue = (int) 1e9;
    public static int maxValue = (int) -1e9;

    // DFS 메서드
    public static void dfs(int i, int now) {
        // 모든 연산자를 다 사용한 경우, 최솟값과 최댓값 업데이트
        if (i == n) {
            minValue = Math.min(minValue, now);
            maxValue = Math.max(maxValue, now);
        }
        else {
            // 각 연산자에 대하여 재귀적으로 수행
            if (add > 0) {
                add -= 1;
                dfs(i+1, now + arr.get(i));
                add += 1;
            }
            if (sub > 0) {
                sub -= 1;
                dfs(i + 1, now - arr.get(i));
                sub += 1;
            }
            if (mul > 0) {
                mul -= 1;
                dfs(i + 1, now * arr.get(i));
                mul += 1;
            }
            if (divi > 0) {
                divi -= 1;
                dfs(i + 1, now / arr.get(i));
                divi += 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr.add(x);
        }

        st = new StringTokenizer(br.readLine());
        add = Integer.parseInt(st.nextToken());
        sub = Integer.parseInt(st.nextToken());
        mul = Integer.parseInt(st.nextToken());
        divi = Integer.parseInt(st.nextToken());

        // DFS 메서드 호출
        dfs(1, arr.get(0));

        // 최댓값과 최솟값 차례대로 출력
        System.out.println(maxValue);
        System.out.println(minValue);
    }
}
