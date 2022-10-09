/*
 * @author Minyeong Park
 * @date 2022.10.09.
 * 접미사 배열
 * 문제 링크 : https://www.acmicpc.net/problem/11656
 */


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String[] arr = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.substring(i);
        }
        Arrays.sort(arr);
        for (String s : arr) {
            System.out.println(s);
        }
    }
}