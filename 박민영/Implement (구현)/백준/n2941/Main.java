/*
 * @author Minyeong Park
 * @date 2022.07.20.
 * 크로아티아 알파벳
 * 참고 및 출처 : https://st-lab.tistory.com/68
 * 문제 링크 : https://www.acmicpc.net/problem/2941
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == 'c') {
                if (i < str.length() - 1) {
                    if (str.charAt(i+1) == '=')
                        i++;
                    else if (str.charAt(i+1) == '-')
                        i++;
                }
            }
            else if (ch == 'd') {
                if (i < str.length() - 1) {
                    if (str.charAt(i+1) == 'z') {
                        if (i < str.length() - 2) {
                            if (str.charAt(i+2) == '=')
                                i += 2;
                        }
                    }
                    else if (str.charAt(i+1) == '-')
                        i++;
                }
            }
            else if (ch == 'l' || ch == 'n') {
                if (i < str.length() - 1) {
                    if (str.charAt(i+1) == 'j')
                        i++;
                }
            }
            else if (ch == 's' || ch == 'z') {
                if (i < str.length() - 1) {
                    if (str.charAt(i+1) == '=')
                        i++;
                }
            }

            count++;
        }

        System.out.println(count);
    }
}

// 메모리 초과가 뜬 처음 코드...
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.next();
//
//        int count = 0;
//        int index = 0;
//        String cur;
//        String next, next2;
//        while (index < str.length()) {
//            if (index == str.length() - 1) {
//                count++;
//                break;
//            }
//            cur = str.charAt(index) + "";
//            switch (cur) {
//                case "c" :
//                    next = str.charAt(index + 1) + "";
//                    if (next.equals("=") || next.equals("-")) {
//                        count++;
//                        index += 2;
//                    } else {
//                        count++;
//                        index += 1;
//                    }
//                    break;
//                case "d" :
//                    next = str.charAt(index + 1) + "";
//                    if (index + 2 < str.length()) {
//                        next2 = str.charAt(index + 2) + "";
//                        if (next.equals("z") || next2.equals("=")) {
//                            count++;
//                            index += 3;
//                        }
//                        break;
//                    }
//                    if (next.equals("-")) {
//                        count++;
//                        index += 2;
//                    } else {
//                        count++;
//                        index += 1;
//                    }
//                    break;
//                case "l" :
//                case "n" :
//                    next = str.charAt(index + 1) + "";
//                    if (next.equals("j")) {
//                        count++;
//                        index += 2;
//                    } else {
//                        count++;
//                        index += 1;
//                    }
//                    break;
//                case "s" :
//                case "z" :
//                    next = str.charAt(index + 1) + "";
//                    if (next.equals("=")) {
//                        count++;
//                        index += 2;
//                    } else {
//                        count++;
//                        index += 1;
//                    }
//                    break;
//                default:
//                    count++;
//                    index += 1;
//            }
//        }
//
//        System.out.println(count);
//    }
//}