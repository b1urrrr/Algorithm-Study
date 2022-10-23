import java.io.*;
import java.util.*;

public class 카드_정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 숫자 카드 묶음의 개수 N 입력
        PriorityQueue<Integer> que = new PriorityQueue<>();

        for (int i = 0; i < N; i++) que.add(Integer.parseInt(br.readLine())); // 숫자 카드 묶음의 크기 입력

        int result = 0;
        // 카드 묶음이 하나가 될 때까지 가장 작은 숫자 카드 묶음 2개를 합치기
        while (que.size() > 1) {
            int a = que.remove();
            int b = que.remove();
            int sum = a + b;

            result += sum;
            que.add(sum);
        }

        // 최소 비교 횟수 출력
        System.out.println(result);
    }
}
