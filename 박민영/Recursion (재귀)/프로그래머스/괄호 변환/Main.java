/*
 * @author Minyeong Park
 * @date 2022.10.22.
 * 괄호 변환
 * 문제 링크 : https://school.programmers.co.kr/learn/courses/30/lessons/60058
 */


import java.util.*;
class Solution {
    // "균형잡힌 괄호 문자열"의 인덱스 반환
    public int balancedIndex(String p) {
        int count = 0; // 왼쪽 괄호의 개수
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(')
                count++;
            else
                count--;

            if (count == 0)
                return i; // 올바른 괄호 문자열이 맞는 곳까지의 인덱스 반환
        }
        return -1;
    }

    // "올바른 괄호 문자열"인지 판단
    public boolean checkProper(String p) {
        int count = 0; // 왼쪽 괄호의 개수
        for (int i = 0 ; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                count++;
            } else {
                if (count == 0) { // 쌍이 맞지 않는 경우에 false 반환
                    return false;
                }
                count--;
            }
        }
        return true; // 쌍이 맞는 경우에 true 반환
    }

    public String solution(String p) {
        String answer = "";
        if (p.equals(""))
            return answer;

        int index = balancedIndex(p);
        String u = p.substring(0, index+1);
        String v = p.substring(index+1);

        // "올바른 괄호 문자열"이면, v에 대해 함수를 수행한 결과를 붙여 반환
        if (checkProper(u)) {
            answer = u + solution(v);
        }
        // "올바른 괄호 문자열"이 아니라면, 아래의 과정을 수행
        else {
            answer = "(";
            answer += solution(v);
            answer += ")";

            u = u.substring(1, u.length() - 1); // 첫 번째와 마지막 문자를 제거
            String temp = "";
            // 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙이는 과정
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(')
                    temp += ")";
                else
                    temp += "(";
            }
            answer += temp;
        }
        return answer;
    }
}