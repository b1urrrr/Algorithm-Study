// chap11 Q3. 문자열 뒤집기 (해설 코드)

import java.util.Scanner;

public class n11_3_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count_1 = 0; // 전부 1로 바꾸는 경우
        int count_0 = 0; // 전부 0으로 바꾸는 경우
        
        // 첫 번째 원소에 대해서 처리
        if (s.charAt(0) == '1') {
            count_0 += 1;
        } else {
            count_1 += 1;
        }

        // 두 번째 원소부터 모든 원소를 확인하며
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i+1)) {
                // 다음 수에서 1로 바뀌는 경우
                if (s.charAt(i+1) == '1') count_0 += 1;
                // 다음 수에서 0으로 바뀌는 경우
                else count_1 += 1;
            }
        }

        System.out.println(Math.min(count_0, count_1));
    }
}
