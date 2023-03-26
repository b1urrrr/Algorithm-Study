import java.util.Scanner;

public class 인공지능_시계 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int hr = stdIn.nextInt();
        int min = stdIn.nextInt();
        int sec = stdIn.nextInt();
        int time = stdIn.nextInt();

        hr += time / 3600;
        time %= 3600;
        min += time / 60;
        time %= 60;
        sec += time;

        if (sec >= 60) {
            min += sec / 60;
            sec %= 60;
        }
        if (min >= 60) {
            hr += min / 60;
            min %= 60;
        }
        if (hr >= 24) {
            hr %= 24;
        }

        System.out.printf("%d %d %d\n", hr, min, sec);

        stdIn.close();
    }
}