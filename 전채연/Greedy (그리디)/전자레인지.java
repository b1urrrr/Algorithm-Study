import java.util.Scanner;

public class 전자레인지 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int T = stdIn.nextInt();
        int[] count = new int[3];

        while (T > 0) {
            if (T >= 300) {
                T -= 300;
                count[0]++;
            } else if (T >= 60) {
                T -= 60;
                count[1]++;
            } else if (T >= 10) {
                T -= 10;
                count[2]++;
            } else {
                System.out.println(-1);
                stdIn.close();
                return;
            }

        }

        for (int i = 0; i < 3; i++) {
            System.out.print(count[i] + " ");
        }
        System.out.println();

        stdIn.close();
    }
}