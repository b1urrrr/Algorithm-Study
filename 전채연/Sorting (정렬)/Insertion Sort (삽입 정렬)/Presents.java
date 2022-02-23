import java.util.Scanner;

public class Presents {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int num = stdIn.nextInt();
        float[] prices = new float[num];
        for (int i = 0; i < num; i++) {
            prices[i] = stdIn.nextFloat();
        }

        for (int i = 1; i < num; i++) {
            float temp = prices[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (prices[j] > temp) {
                    prices[j + 1] = prices[j];
                } else break;
            }
            prices[j + 1] = temp;
        }

        System.out.printf("%.2f\n", prices[1]);
    }
}
