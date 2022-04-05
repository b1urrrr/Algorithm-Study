/*
    백준 7568번 : 덩치
    - 문제 유형 : 브루트포스 알고리즘
*/

import java.io.*;
import java.util.StringTokenizer;

public class 덩치 {
    // 몸무게와 키를 저장할 클래스
    static class Bulk {
        int weight; // 몸무게
        int height; // 키

        // 생성자
        Bulk(int w, int h) {
            this.weight = w;
            this.height = h;
        }

        // 비교 메서드 - this보다 덩치가 더 크면 true 반환
        boolean compare(Bulk b) {
            if (this.weight < b.weight && this.height < b.height)
                return true;
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine()); // 전체 사람의 수
        Bulk[] people = new Bulk[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int weight = Integer.parseInt(st.nextToken()); // 몸무게 입력
            int height = Integer.parseInt(st.nextToken()); // 키 입력

            people[i] = new Bulk(weight, height); // 배열에 객체 대입
        }

        // 모든 경우의 수 탐색
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (people[i].compare(people[j])) count++; // 덩치가 더 큰 사람이라면 count 증가
            }
            bw.write((count + 1) + " "); // 덩치 등수 출력
        }
        bw.newLine();

        br.close();
        bw.flush();
        bw.close();
    }
}
