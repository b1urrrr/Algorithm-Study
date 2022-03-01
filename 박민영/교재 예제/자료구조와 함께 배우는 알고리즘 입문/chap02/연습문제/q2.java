import java.util.Scanner;
import java.util.StringTokenizer;

public class q2 {
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            System.out.println("a[" + i + "]과(와) a[" + (a.length - i - 1) + "]를 교환합니다.");
            swap(a, i, a.length - i - 1);
            for (int j = 0; j < a.length; j++)
                System.out.printf("%d ", a[j]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        String input = stdIn.nextLine();
        StringTokenizer st = new StringTokenizer(input);
        int num = st.countTokens();

        int[] x = new int[num];
        for (int i = 0; i < num; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        reverse(x);

        System.out.println("역순 정렬을 마쳤습니다.");
    }
}
