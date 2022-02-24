import java.util.Scanner;

public class 거북이 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int[] steps = new int[4];
        for (int i = 0; i < 4; i++) {
            steps[i] = stdIn.nextInt(); 
        }

        for(int i = 1; i < 4; i++) {
            int temp = steps[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (steps[j] > temp) steps[j + 1] = steps[j];
                else break;
            }
            steps[j + 1] = temp;
        }

        System.out.println(steps[0] * steps[2]);
    } 
}
