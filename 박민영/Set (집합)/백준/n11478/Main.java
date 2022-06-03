/*
 * @author Minyeong Park
 * @date 2022.06.03.
 * 서로 다른 부분 문자열의 개수
 * 참고 : https://byul91oh.tistory.com/309, https://airzinc.tistory.com/entry/%EB%B0%B1%EC%A4%80-11478JAVA
 * 문제 링크 : https://www.acmicpc.net/problem/11478
 */

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        HashSet<String> set = new HashSet<>();
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                str += s.substring(j, j+1);
                set.add(str);
            }

            str = "";
        }

        System.out.println(set.size());
    }
}