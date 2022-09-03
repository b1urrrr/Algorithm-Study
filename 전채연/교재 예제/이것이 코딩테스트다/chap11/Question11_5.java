import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.lang.Comparable;

public class Question11_5 {
    static class Ball implements Comparable<Ball> {
        int num;
        int weight;

        Ball(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Ball other) {
            if (this.weight > other.weight) return 1;
            else if (this.weight < other.weight) return -1;
            else return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 볼링공의 개수 입력
        int M = Integer.parseInt(st.nextToken()); // 볼링공의 최대 무게 입력
        Ball[] balls = new Ball[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            balls[i] = new Ball(i, Integer.parseInt(st.nextToken())); // 무게별 볼링공 개수 집계
        }

        Arrays.sort(balls);

        int count = 0;
        // A의 볼링공 선택
        for (int i = 0; i < N - 1; i++) {
            // B의 볼링공 선택
            for (int j = i + 1; j < N; j++) {
                if (balls[j].weight == balls[i].weight) continue;
                count++;
            }
        }

        // 두 사람이 볼링공을 고르는 경우의 수 출력
        System.out.println(count);
    }
}
