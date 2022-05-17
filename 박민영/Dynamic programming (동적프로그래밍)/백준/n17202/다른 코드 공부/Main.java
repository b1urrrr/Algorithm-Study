/*
 * @author Minyeong Park
 * @date 2022.02.27.
 * 핸드폰 번호 궁합 (문자열, 문자 활용 방법 풀이)
 * https://www.acmicpc.net/problem/17202
 */


import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1, s2; // 번호1, 번호2
        String add = "";    // 새로 만든 문자열
        String res = "";    // 새로 만든 문자열에서 번호 궁합을 한 결과

        s1 = br.readLine();
        s2 = br.readLine();

        for (int i = 0; i < s1.length(); i++) { // 두 개의 문자열을 서로 번갈아가면서 새로운 문자열 만들기
            add = add + s1.charAt(i) + s2.charAt(i);
        }

        // add의 길이가 2가 되기 전까지 반복함
        while (add.length() != 2) {
            for (int i = 0; i < add.length() - 1; i++) {
                res = res + (Character.getNumericValue(add.charAt(i)) + Character.getNumericValue(add.charAt(i+1))) % 10;
            }
            add = res; //새로 만든 문자열을 궁합 결과로 갱신함
            res = "";  // 번호 궁합 결과 문자열은 초기화
        }
        bw.write(add);

        bw.flush();
    }
}