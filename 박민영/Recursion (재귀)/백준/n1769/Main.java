/*
 * @author Minyeong Park
 * @date 2022.03.20.
 * 3의 배수 (제 방식대로 풀어보긴 했으나 계속 막혀서.. 결국.. 다른 분의 코드와 원리를 공부하면서 해결하였습니다...)
 * 참고한 글 : https://chaewsscode.tistory.com/64
 * https://www.acmicpc.net/problem/1769
 */


import java.io.*;

public class Main {
    static void three(String str, int count) {
        if (str.length() > 1) {
            count++;
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += Integer.parseInt(str.charAt(i) + "");
            }
            three(sum + "", count);
        } else {
            if (Integer.parseInt(str) % 3 == 0) {
                System.out.println(count);
                System.out.println("YES");
            }
            else {
                System.out.println(count);
                System.out.println("NO");
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String num = br.readLine();
        three(num, 0);
    }
}