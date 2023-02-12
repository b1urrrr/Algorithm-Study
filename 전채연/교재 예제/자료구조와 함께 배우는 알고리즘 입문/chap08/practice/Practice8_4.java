package chap08.practice;

import java.util.Scanner;

public class Practice8_4 {
    static void printBlank(String s, int pt) {
        for (int i = 0; i < pt; i++) {
            int bytes = s.substring(i, i + 1).getBytes().length;
            for (int j = 0; j < bytes; j++) System.out.print(" ");
        }
    }

    static int bmMatch(String txt, String pat) {
        int pt;
        int pp;
        int txtLen = txt.length();
        int patLen = pat.length();
        int[] skip = new int[Character.MAX_VALUE + 1];
        int count = 0;

        for (pt = 0; pt <= Character.MAX_VALUE; pt++)
            skip[pt] = patLen;
        for (pt = 0; pt < patLen - 1; pt++)
            skip[pat.charAt(pt)] = patLen - pt - 1;

        while (pt < txtLen) {
            boolean isSame = false;
            boolean isFirst = true;
            pp = patLen - 1;

            while (txt.charAt(pt) == pat.charAt(pp)) {
                isSame = true;
                if (isFirst) System.out.printf("%d %s\n", count, txt);
                else System.out.printf("  %s\n", txt);
                isFirst = false;
                System.out.print("  "); printBlank(txt, pt); System.out.println("+");
                System.out.print("  "); printBlank(txt, pt - pp); System.out.println(pat);
                if (pp == 0)
                    return pt;
                pp--;
                pt--;
            }
            if (!isSame) {
                System.out.printf("%d %s\n", count, txt);
                System.out.print("  "); printBlank(txt, pt + pp); System.out.println("|");
                System.out.print("  "); printBlank(txt, pt); System.out.println(pat);
            }
            pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트 : ");
        String s1 = stdIn.next();

        System.out.print("  패턴 : ");
        String s2 = stdIn.next();

        int idx = bmMatch(s1, s2);

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

        stdIn.close();
    } 
}
