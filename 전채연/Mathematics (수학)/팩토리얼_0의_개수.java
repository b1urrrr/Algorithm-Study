import java.io.*;
import java.math.BigInteger;

public class 팩토리얼_0의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        BigInteger result = new BigInteger("1");
        for (int i = 2; i <= num; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }

        int count = 0;
        while (result.compareTo(new BigInteger("0")) > 0) {
            if (result.remainder(new BigInteger("10")).compareTo(new BigInteger("0")) == 0) {
                count++;
            } else break;
            result = result.divide(new BigInteger("10"));
        }

        System.out.println(count);
    }
}
