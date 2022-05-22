/*
 * @author Minyeong Park
 * @date 2022.05.22.
 * 나는야 포켓몬 마스터 이다솜
 * 참고 : Hashmap - https://coding-factory.tistory.com/556,
 *       문자열이 숫자인지 확인(Character클래스의 isDigit()) - https://www.delftstack.com/ko/howto/java/how-to-check-if-a-string-is-a-number-in-java/,
 *       풀이 참고 - https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-1620-%EB%82%98%EB%8A%94%EC%95%BC-%ED%8F%AC%EC%BC%93%EB%AA%AC-%EB%A7%88%EC%8A%A4%ED%84%B0-%EC%9D%B4%EB%8B%A4%EC%86%9C-JAVA%EC%9E%90%EB%B0%94,
 *       객체타입 확인(instanceof) - https://velog.io/@geesuee/JAVA-%EA%B0%9D%EC%B2%B4-%ED%83%80%EC%9E%85-%ED%99%95%EC%9D%B8-instanceof (안 썼지만 첨부)
 * 문제 링크 : https://www.acmicpc.net/problem/1620
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> dic1 = new HashMap<String, Integer>(); // 이름 : 번호
        HashMap<Integer, String> dic2 = new HashMap<Integer, String>(); // 번호 : 이름
        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            dic1.put(input, i);
            dic2.put(i, input);
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (!Character.isDigit(str.charAt(0))) { // 문자인 경우
                System.out.println(dic1.get(str));
            } else {                                 // 정수인 경우
                int num = Integer.parseInt(str);
                System.out.println(dic2.get(num));
            }
        }
    }
}