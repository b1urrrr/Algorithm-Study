/*
    백준 1181번 : 단어 정렬
    - 문제 유형 : 문자열, 정렬
    - 풀이 유형 : Arrays.sort를 활용한 이중 피벗 퀵 정렬 (Dual Pivot Quick Sort)
*/

import java.io.*;
import java.util.Comparator;
import java.util.Arrays;

public class 단어_정렬 {
    // Comparator를 상속받는 클래스 구현
    public static class Comp implements Comparator<String> {
        // 길이 오름차순, 길이가 같으면 사전순으로 비교 결과 반환
        public int compare(String s1, String s2) {
            if (s1.length() > s2.length()) return 1;
            else if (s1.length() < s2.length()) return -1;
            else return s1.compareTo(s2);
        }
    } 

    // Comparator 객체 생성
    static final Comparator<String> COMPARATOR = new Comp();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 단어의 개수 입력
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine(); // 단어 입력
        }

        // Arrays.sort : 이중 피벗 퀵 정렬
        Arrays.sort(words, COMPARATOR);

        bw.write(words[0] + "\n"); // 첫 번째 단어 출력
        for (int i = 1; i < N; i++) {
            if (words[i - 1].equals(words[i])) continue; // 뒤 단어와 같은 단어이면 출력하지 않음.
            bw.write(words[i] + "\n"); // 단어 출력
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
