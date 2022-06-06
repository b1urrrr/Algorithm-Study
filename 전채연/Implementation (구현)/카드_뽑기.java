/*
    백준 16204번 : 카드 뽑기
    - 문제 유형 : 구현
*/

import java.io.*;
import java.util.StringTokenizer;

public class 카드_뽑기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cards = Integer.parseInt(st.nextToken());
        int frontO = Integer.parseInt(st.nextToken());
        int frontX = cards - frontO;
        int backO = Integer.parseInt(st.nextToken());
        int backX = cards - backO;
        int count = Math.min(frontO, backO) + Math.min(frontX, backX);
        System.out.println(count);
    }
}

