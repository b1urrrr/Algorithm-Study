import com.sun.jdi.Value;

import java.util.Arrays;
import java.util.Scanner;

public class n12_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String temp_str = "";
        int index = 0;
        int num_sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                num_sum += Integer.parseInt(str.charAt(i) + "");
            } else {
                temp_str += str.charAt(i);
            }
        }

        char[] arr = temp_str.toCharArray();
        Arrays.sort(arr);
        String answer = "";
        for (char ch : arr) {
            answer += ch;
        }
        answer += num_sum;
        System.out.println(answer);
    }
}
