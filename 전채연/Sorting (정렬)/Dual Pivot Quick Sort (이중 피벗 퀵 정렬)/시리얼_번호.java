/*
    백준 1431번 : 시리얼 번호
    - 문제 유형 : 정렬
    - 풀이 유형 : Arrays.sort를 활용한 이중 피벗 퀵 정렬 (Dual Pivot Quick Sort)
*/

import java.io.*;
import java.util.*;

public class 시리얼_번호 {
    static class Serial implements Comparable<Serial> {
        String serialNum;
        int sum;

        public Serial(String serialNum) {
            this.serialNum = serialNum;
            this.sum = 0;
            
            // 자릿수 합 계산
            for (int i = 0; i < serialNum.length(); i++) {
                if (serialNum.charAt(i) <= '9') this.sum += serialNum.charAt(i) - '0';
            }
        }

        @Override
        public int compareTo(Serial other) {
            // 길이와 자릿수 합이 같으면 사전순 비교
            if (this.serialNum.length() == other.serialNum.length() && this.sum == other.sum) return this.serialNum.compareTo(other.serialNum);
            // 길이가 같으면 자릿수 합 비교
            else if (this.serialNum.length() == other.serialNum.length()) return Integer.compare(this.sum, other.sum);
            // 길이 비교
            else return Integer.compare(this.serialNum.length(), other.serialNum.length());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 기타의 개수 N 입력
        Serial[] serials = new Serial[N];

        for (int i = 0; i < N; i++) {
            serials[i] = new Serial(br.readLine()); // 시리얼 번호 입력
        }

        // 정렬
        Arrays.sort(serials);

        // 시리얼 번호를 정렬한 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.println(serials[i].serialNum);
        }
    }
}
