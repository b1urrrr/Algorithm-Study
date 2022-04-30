/*
    백준 1107번 : 리모컨
    - 문제 유형 : 브루트포스 알고리즘
*/

import java.io.*;
import java.util.StringTokenizer;

public class 리모컨 {
    static final int SIZE = 10;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] btn = new int[SIZE]; // 숫자 버튼이 부러진 여부 저장

        int channel = Integer.parseInt(br.readLine()); // 수빈이가 이동하려는 채널
        int btnCount = Integer.parseInt(br.readLine()); // 부러진 버튼의 개수

        if (btnCount > 0) { // 부러진 버튼이 있을 때만 추가로 입력
            String s2 = br.readLine();
            StringTokenizer st = new StringTokenizer(s2);
            for (int i = 0; i < btnCount; i++) 
                btn[Integer.parseInt(st.nextToken())]++; // 부러진 버튼은 btn배열에서 1로 증가시킴
        }

        int result = Math.abs(channel - 100); // 100번 채널에서 + 또는 -로만 이동한 경우의 버튼 클릭 횟수

        // 숫자 버튼으로 0 ~ 999999로 이동하는 경우 탐색
        Search : for (int i = 0; i < 1000000; i++) {
            int num = i;
            int length = String.valueOf(num).length();
            // 부러진 버튼의 숫자를 포함한 채널은 탈락
            for (int j = 0; j < length; j++) {
                if (btn[num % 10] > 0) continue Search;
                num /= 10; 
            }
            // i에서 원하는 채널로 이동하며 버튼을 누른 횟수 + 채널을 입력하며 숫자 버튼을 누른 횟수
            result = Math.min(result, Math.abs(channel - i) + length); // 최솟값 저장
        }

        // 버튼 클릭 횟수의 최솟값 출력
        System.out.println(result);
    }
}
