import java.util.Scanner;

public class 시험_점수 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int sum1 = 0;
        int sum2 = 0;
        
        for (int i = 0; i < 4; i++) {
            sum1 += stdIn.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            sum2 += stdIn.nextInt();
        }
        
        int result = (sum1 >= sum2) ? sum1 : sum2;
        System.out.println(result);

        stdIn.close();
    }
}