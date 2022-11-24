import java.util.Scanner;

public class 오븐_시계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int curHour = sc.nextInt();
        int curSec = sc.nextInt();
        int duration = sc.nextInt();
        curSec += duration;
        
        curHour += curSec / 60;
        curSec %= 60;
        curHour %= 24;
        
        System.out.print(curHour + " " + curSec);
    }
}