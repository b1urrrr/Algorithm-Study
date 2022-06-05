// chap04 (1) 예제 4-2 : 시각 (해설 코드 참고하면서 수정한 것)
import java.util.Scanner;

public class n4_2_2 {
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

        /*
        // 또는 더 간단하게 3중 반복문으로도 구현 가능
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    // 매 시각 안에 3이 포함되어 있다면 카운트 증가
                    if (have3(i,j,k)) count++;
                }
            }
        }
         */
    }

    static boolean have3 (int hour, int min, int sec) {
        if (hour % 10 == 3 || min / 10 == 3 || min % 10 == 3 || sec / 10 == 3 || sec % 10 == 3)
            return true;
        return false;
    }
}
