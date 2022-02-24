import java.util.Scanner;

public class 세수정렬 {
    static int max3(int[] scores, int count) {
        for (int i = 1; i < count; i++) {
            int temp = scores[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (scores[j] > temp) scores[j + 1] = scores[j];
                else break;
            }
            scores[j + 1] = temp;
        }
        return scores[count - 1] + scores[count - 2] + scores[count - 3];
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int[] W = new int[10];
        int[] K = new int[10];
        for (int i = 0; i < 10; i++) {
            W[i] = stdIn.nextInt();
        }
        for (int i = 0; i < 10; i++) {
            K[i] = stdIn.nextInt();
        }
        System.out.printf("%d ", max3(W, 10));
        System.out.print(max3(K, 10));
    }
}