/*
    백준 4153번 : 직각삼각형
    - 문제 유형 : 수학, 기하학, 피타고라스의 정리
*/

import java.io.*;
import java.util.StringTokenizer;

public class 직각삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int[] length = new int[3];
            int max = 0;

            for (int i = 0; i < 3; i++) {
                length[i] = Integer.parseInt(st.nextToken()); // 변의 길이 입력
                max = (length[max] > length[i]) ? max : i; // 최댓값 탐색
            }

            if (length[0] == 0 && length[1] == 0 && length[2] == 0) break; // 세 변의 길이가 모두 0이면 종료
            
            int longest = 0;
            int others = 0;

            for (int i = 0; i < 3; i++) {
                if (i == max) longest = (int) Math.pow(length[i], 2); // 가장 긴 변의 제곱
                else others += (int) Math.pow(length[i], 2); // 나머지 변의 제곱을 합함
            }

            // 결과 출력 : 가장 긴 변의 제곱과 나머지 두 변의 제곱의 합이 같으면 직각삼각형
            if (longest == others) bw.write("right\n");
            else bw.write("wrong\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
