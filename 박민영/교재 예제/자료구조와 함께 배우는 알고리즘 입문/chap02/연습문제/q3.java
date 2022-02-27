import java.util.Scanner;
import java.util.StringTokenizer;

public class q3 {
    static int sumOf(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];
        return sum;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String input = stdIn.nextLine();
        StringTokenizer st = new StringTokenizer(input);
        int num = st.countTokens();

        int[] a = new int[num];
        for (int i = 0; i < num; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println("배열 a의 모든 요소의 합계는 " + sumOf(a) + "입니다.");
    }
}
