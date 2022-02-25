import java.util.Scanner;

public class q8 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.print("n의 값 : ");
        int n = stdIn.nextInt();

        int sum = 0;

        sum = (1 + n) * (n / 2);
        if (n % 2 != 0) sum += n / 2 + 1; //홀수인 경우 중앙값을 더해줘야 함
        System.out.println(sum);
    }
}
