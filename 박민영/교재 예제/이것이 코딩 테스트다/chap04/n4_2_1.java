// chap04 (1) 예제 4-2 : 시각 (내가 푼 것)
// 각 자리에 3이 있는지를 체크하는 함수가 너무 복잡한 것 같음.
import java.util.Scanner;

public class n4_2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int hour = 0;
        int min = 0;
        int sec = 0;

        int count = 0;
        while (hour <= N) {
            sec += 1;
            if (sec >= 60) {
                min++;
                sec -= 60;
            }
            if (min >= 60) {
                hour++;
                min -= 60;
            }
            if (have3(hour, min, sec)) {
                count++;
            }
        }
        System.out.println(count);
    }

    static boolean have3 (int hour, int min, int sec) {
        if (String.valueOf(hour).charAt(0) == '3' || String.valueOf(min).charAt(0) == '3' || String.valueOf(sec).charAt(0) == '3') {
            return true;
        }

        if (String.valueOf(hour).length() == 2)
            if (String.valueOf(hour).charAt(1) == '3')
                return true;

        if (String.valueOf(min).length() == 2)
            if (String.valueOf(min).charAt(1) == '3')
                return true;

        if (String.valueOf(sec).length() == 2)
            if (String.valueOf(sec).charAt(1) == '3')
                return true;
        return false;
    }
}
