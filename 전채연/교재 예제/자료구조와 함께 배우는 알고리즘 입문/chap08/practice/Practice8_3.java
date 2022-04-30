package chap08.practice;

import java.util.Scanner;

public class Practice8_3 {
    static void printBlank(String s, int pt) {
        for (int i = 0; i < pt; i++) {
            int bytes = s.substring(i, i + 1).getBytes().length;
            for (int j = 0; j < bytes; j++) System.out.print(" ");
        }
    }

    static int kmpMatch(String txt, String pat) {
        int pt = 1;
        int pp = 0;
        int lastPt = -1;
        int[] skip = new int[pat.length() + 1];

        skip[pt] = 0;
        while (pt != pat.length()) {
            if (pat.charAt(pt) == pat.charAt(pp))
                skip[++pt] = ++pp;
            else if (pp == 0)
                skip[++pt] = pp;
            else
                pp = skip[pp];
        }

        // 검색
        pt = pp = 0;
        while (pt != txt.length() && pp != pat.length()) {
            if (lastPt != pt - pp) {
                System.out.printf("%d %s\n", pt, txt);
                lastPt = pt - pp;
            } else System.out.printf("  %s\n", txt);
            if (txt.charAt(pt) == pat.charAt(pp)) {
                System.out.print("  ");
                printBlank(txt, pt);
                System.out.println("+");
                System.out.print("  ");
                printBlank(txt, pt - pp);
                System.out.println(pat);
                pt++;
                pp++;
            } else if (pp == 0) {
                System.out.print("  ");
                printBlank(txt, pt);
                System.out.println("|");
                System.out.print("  ");
                printBlank(txt, pt - pp);
                System.out.println(pat);
                pt++;
            } else { 
                System.out.print("  ");
                printBlank(txt, pt);
                System.out.println("|");
                System.out.print("  ");
                printBlank(txt, pt - pp);
                System.out.println(pat);
                pp = skip[pp];
            }
        }

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

        int idx = kmpMatch(s1, s2);

        if (idx == -1)
            System.out.println("텍스트에 패턴이 없습니다.");
        else {
            int len = 0;
            for (int i = 0; i < idx; i++)
                len += s1.substring(i, i + 1).getBytes().length;
            len += s2.length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트 : " + s1);
            System.out.printf(String.format("  패턴 : %%%ds\n", len), s2);
        }
    }
}