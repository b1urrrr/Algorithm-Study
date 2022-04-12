/*
    백준 10250번 : ACM 호텔
    - 문제 유형 : 수학
*/

import java.io.*;
import java.util.StringTokenizer;

public class ACM_호텔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
        
        for (int i = 0; i < testCase; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            
            int floors = Integer.parseInt(st.nextToken()); // 호텔의 층 수
            int rooms = Integer.parseInt(st.nextToken()); // 각 층의 방 수
            int customer = Integer.parseInt(st.nextToken()); // 손님의 번호 (몇 번째 손님인지)

            int Y = customer % floors;      // 방 번호의 앞자리
            int X = customer / floors + 1;  // 반 번호의 뒷자리
            // 손님의 번호가 호텔 층 수의 배수이면 방 번호의 앞자리는 층 수, 뒷자리는 손님의 번호에 층수를 나눈 결과가 됨
            if (Y == 0) {
                Y = floors;
                X--;
            }
            bw.write(((Y * 100) + X) + "\n"); // 방 번호 출력
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
