// chap11 Q3. 문자열 뒤집기

import java.util.Scanner;

public class n11_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int count_1 = 0;
        int count_0 = 0;
        
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) - '0' == 0) {
                while (index < s.length() && s.charAt(index) - '0' == 0) {
                    index++;
                }
                count_0++;
            } else if (s.charAt(index) - '0' == 1) {
                while (index < s.length() && s.charAt(index) - '0' == 1) {
                    index++;
                }
                count_1++;
            }
        }

        System.out.println(Math.min(count_0, count_1));
    }
}
