package chap01.practice;
import java.util.Scanner;

public class Practice1_7 {
   public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.print("n의 값 : "); int n = stdIn.nextInt();
        
        int sum = 0;
        int i = 1;
        
        for ( ; i < n; i++) {
            System.out.print(i + " + ");
            sum += i;
        }
        
        sum += i;
        System.out.println(i + " = " + sum);
   } 
}
