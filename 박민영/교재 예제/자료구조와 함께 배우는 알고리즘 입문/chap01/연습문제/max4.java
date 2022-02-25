import java.util.Scanner;

public class max4 {
    static int max4(int a, int b, int c, int d) {
        int max = a; //일단 a를 최댓값으로 설정
        if (max < b) {
            max = b;
        } else if (max < c) {
            max = c;
        } else if (max < d) {
            max = d;
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(max4(a,b,c,d));
    }
}
