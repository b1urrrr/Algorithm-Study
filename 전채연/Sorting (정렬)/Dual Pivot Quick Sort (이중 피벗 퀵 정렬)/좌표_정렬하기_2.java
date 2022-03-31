/*
    백준 11651번 : 좌표 정렬하기 2
    - 문제 유형 : 정렬
    - 풀이 유형 : Arrays.sort를 활용한 이중 피벗 퀵 정렬 (Dual Pivot Quick Sort)
*/

import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class 좌표_정렬하기_2 {
    // 점의 좌표를 저장하는 클래스
    static class Dot {
        private int x;
        private int y;

        public Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return x + " " + y;
        }
    }

    // Comparator 상속 클래스 구현
    public static class Comp implements Comparator<Dot> {
        // y 좌표 오름차순, 동일하면 x 좌표 오름차순으로 정렬
        public int compare(Dot d1, Dot d2) {
            if (d1.y < d2.y) return -1;
            else if (d1.y > d2.y) return 1;
            else if (d1.x < d2.x) return -1;
            else return 1;
        }
    } 

    // Comparator 객체
    static final Comparator<Dot> COMPARATOR = new Comp();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine()); // 점의 개수
        Dot[] dots = new Dot[N]; // 점을 저장하는 배열

        for (int i = 0; i < N; i++) {
            String s = br.readLine(); // 좌표 입력
            StringTokenizer st = new StringTokenizer(s);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            dots[i] = new Dot(x, y);
        }

        // 정렬
        Arrays.sort(dots, COMPARATOR);

        // 출력
        for (int i = 0; i < N; i++) {
            bw.write(dots[i] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}