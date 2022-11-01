package chap16;

import java.io.*;
import java.util.*;

public class Question16_35 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 구하고자하는 못생긴 수의 순서 n 입력
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 5; i++) numbers.add(i);

        for (int i = 6; ; i++) {
            // n 번째 못생긴 수를 찾았다면 종료
            if (numbers.size() >= n) break;

            int num = i;
            A: for (int j = numbers.size() - 1; j > 0; j--) {
                while (num % numbers.get(j) == 0) {
                    num /= numbers.get(j);
                    // 못생긴 수이면 추가
                    if (num == 1) {
                        numbers.add(i);
                        break A;
                    }
                }
            }
        }

        // n번째 못생긴 수 출력
        System.out.println(numbers.get(n - 1));
    }
}
