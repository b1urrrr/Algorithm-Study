import java.io.*;

public class 팩토리얼_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        long result = 1;

        for (int i = 2; i <= N; i++) {
            result *= i;
        }

        System.out.println(result);
    }
}
