import java.util.Scanner;

public class q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count = 1;    //자리수 (적어도 1자리이므로 1로 초기화)
        int num = input;  //복사
        while (num >= 10) {
            num /= 10;
            count++;
        }
        System.out.println("그 수는 " + count + "자리입니다.");
    }
}
