/*
 * @author Minyeong Park
 * @date 2022.07.20.
 * 다이얼
 * 문제 링크 : https://www.acmicpc.net/problem/2941
 */


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int time = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'A' || c == 'B' || c == 'C')
                time += 3;
            else if (c == 'D' || c == 'E' || c == 'F')
                time += 4;
            else if (c == 'G' || c == 'H' || c == 'I')
                time += 5;
            else if (c == 'J' || c == 'K' || c == 'L')
                time += 6;
            else if (c == 'M' || c == 'N' || c == 'O')
                time += 7;
            else if (c == 'P' || c == 'Q' || c == 'R' || c == 'S')
                time += 8;
            else if (c == 'T' || c == 'U' || c == 'V')
                time += 9;
            else if (c == 'W' || c == 'X' || c == 'Y' || c == 'Z')
                time += 10;
        }
        System.out.println(time);
    }
}