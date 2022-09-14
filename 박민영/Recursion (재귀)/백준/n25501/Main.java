/*
 * @author Minyeong Park
 * @date 2022.09.14.
 * 재귀의 귀재
 * 문제 링크 : https://www.acmicpc.net/problem/25501
 */

import java.util.*;

public class Main {
    static int count = 0;
    public static int recursion(String s, int l, int r){
        count++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            count = 0;
            String str = sc.next();
            System.out.println(isPalindrome(str) + " " + count);
        }
    }
}