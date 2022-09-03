import java.io.*;

public class Question11_2_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); // 문자열 S 입력

        long result = Integer.parseInt(String.valueOf(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            int b = Integer.parseInt(String.valueOf(s.charAt(i)));

            // 더한 값과 곱한 값 중 최대값 저장
            result = Math.max(result + b, result * b);
        }

        // 만들어질 수 있는 가장 큰 수 출력
        System.out.println(result);
    }
}
