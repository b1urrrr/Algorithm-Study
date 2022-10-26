import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n13_19_re {
    static int n;
    // 연산을 수행하고자 하는 수 리스트
    static ArrayList<Integer> arr = new ArrayList<>();
    // 더하기, 빼기, 곱하기, 나누기 연산자 개수
    static int add, sub, mul, divi;

    // 최솟값과 최댓값 초기화
    static int minValue = (int) 1e9;
    static int maxValue = (int) -1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        add = Integer.parseInt(st.nextToken());
        sub = Integer.parseInt(st.nextToken());
        mul = Integer.parseInt(st.nextToken());
        divi = Integer.parseInt(st.nextToken());

        // DFS 메서드 호출
        dfs(1, arr.get(0));

        System.out.println(maxValue);
        System.out.println(minValue);
    }

    static void dfs(int i, int now) { // i : 몇 번째 수까지 다룬건지, now : i번째 수까지 다루었을 때의 현재 연산 진행 값
        // 모든 연산자를 다 사용한 경우, 최솟값과 최댓값 업데이트
        if (i == n) {
            minValue = Math.min(now, minValue);
            maxValue = Math.max(now, maxValue);
        } else {
            // 각 연산자에 대하여 재귀적으로 수행
            if (add > 0) {
                add -= 1;
                dfs(i+1, now + arr.get(i));
                add += 1;
            }
            if (sub > 0) {
                sub -= 1;
                dfs(i+1, now - arr.get(i));
                sub += 1;
            }
            if (mul > 0) {
                mul -= 1;
                dfs(i+1, now * arr.get(i));
                mul += 1;
            }
            if (divi > 0) {
                divi -= 1;
                dfs(i+1, now / arr.get(i));
                divi += 1;
            }
        }
    }
}