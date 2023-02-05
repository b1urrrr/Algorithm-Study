import java.util.Scanner;

public class 심부름_가는_길 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int sum = 0;
        
        for (int i = 0; i < 4; i ++) {
            sum += stdIn.nextInt();
        }

        System.out.println(sum / 60);
        System.out.println(sum % 60);
    }
}
