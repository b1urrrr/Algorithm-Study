// chap11 Q2.곱하기 혹은 더하기 (내가 푼 코드)

import java.util.Scanner;

public class n11_2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int index = 0;
        int result = 1;
        if (str.length() == 1) {
            System.out.println(str);
            return;
        }

        if (str.length() >= 2) {
            int first = Integer.parseInt(str.charAt(0) + "");
            int second = Integer.parseInt(str.charAt(1) + "");

            if (first == 0 || first == 1) {
                result = first + second;
                index = 2;
            }
        }

        while (index < str.length()) {
            int cur_num = Integer.parseInt(str.charAt(index) + "");
            if (cur_num == 0 || cur_num == 1) {
                result = result + cur_num;
            } else {
                result = result * cur_num;
            }
            index++;
        }
        System.out.println(result);
    }
}
