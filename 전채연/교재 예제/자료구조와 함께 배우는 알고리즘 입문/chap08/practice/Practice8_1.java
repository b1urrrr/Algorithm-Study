package chap08.practice;

import java.util.Scanner;

public class Practice8_1 {
    static int bfMatch(String txt, String pat) {
        int pt = 0;
        int pp = 0;
        int lastPt = -1;
        int count = 0;

        while (pt != txt.length() && pp != pat.length()) {
            if (lastPt != pt - pp) {
                System.out.printf("%d %s\n", pt, txt);
                lastPt = pt - pp;
            } else System.out.printf("  %s\n", txt);
            if (txt.charAt(pt) == pat.charAt(pp)) {
                System.out.print("  ");
                for (int i = 0; i < pt; i++) System.out.print(" ");
                System.out.println("+");
                System.out.print("  ");
                for (int i = 0; i < pt; i++) System.out.print(" ");
                System.out.println(pat);
                pt++;
                pp++;
            } else {
                System.out.print("  ");
                for (int i = 0; i < pt; i++) System.out.print(" ");
                System.out.println("|");
                System.out.print("  ");
                for (int i = 0; i < pt - pp; i++) System.out.print(" ");
                System.out.println(pat);
                pt = pt - pp + 1;
                pp = 0;
            }
            count++;
            System.out.println();
        }
        System.out.printf("비교는 %d회였습니다.\n", count);
        if (pp == pat.length())
            return pt - pp;
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트 : ");
        String s1 = stdIn.next();

        System.out.print("패턴 : ");
        String s2 = stdIn.next();

        int idx = bfMatch(s1, s2);

        if (idx == -1)
            System.out.println("텍스트에 패턴이 없습니다.");
        else {
            int len = 0;
            for (int i = 0; i < idx; i++)
                len += s1.substring(i, i + 1).getBytes().length;
            len += s2.length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트 : " + s1);
            System.out.printf(String.format("패턴 : %%%ds\n", len), s2);
        }
    }  
}
