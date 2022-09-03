import java.io.*;

public class Question11_3_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(); // 문자열 S 입력

        int count = 0;
        char c = S.charAt(0);
        for (int i = 1; i < S.length(); i++) {
            // 이전과 다른 문자가 입력되었다면 count 증가
            if (c != S.charAt(i)) {
                count++;
                c = S.charAt(i);
            }
        }

        // 다른 문자가 입력된 경우의 횟수에 1을 더하고 2로 나눈 값 출력
        System.out.println((count + 1) / 2);
    }
}
