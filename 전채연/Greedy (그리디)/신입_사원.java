/*
    백준 1946번 : 신입 사원
    - 문제 유형 : 그리디 알고리즘, 정렬
*/

import java.io.*;
import java.util.*;

public class 신입_사원 {
    static class Score implements Comparable<Score> {
        int document;
        int interview;

        public Score(int document, int interview) {
            this.document = document;
            this.interview = interview;
        }

        @Override
        public int compareTo(Score other) {
            return Integer.compare(this.document, other.document);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수 T 입력

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 지원자의 숫자 N 입력
            Score[] scores = new Score[N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int document = Integer.parseInt(st.nextToken()); // 지원자의 서류 심사 성적 입력
                int interview = Integer.parseInt(st.nextToken()); // 지원자의 면접 심사 성적 입력
                scores[i] = new Score(document, interview);
            }

            // 서류 심사 성적을 기준으로 오름차순 정렬
            Arrays.sort(scores);

            int result = N;
            int min = 0;
            for (int i = 1; i < N; i++) {
                if (scores[i].interview < scores[min].interview) min = i;
                else result--;
            }

            // 진영 주식회사가 선발할 수 있는 신입사원의 최대 인원수 출력
            bw.write(result + "\n");
        }
        bw.flush();
    }
}