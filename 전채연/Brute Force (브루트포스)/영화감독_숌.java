/*
    백준 1436번 : 영화감독 숌
    - 문제 유형 : 브루트포스 알고리즘
*/

import java.io.*;

public class 영화감독_숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // N 입력
        int count = 1; // "666"이 들어간 수 카운팅 변수
        int num = 666; // 666부터 1씩 증가시켜 "666"이 들어간 수를 탐색할 때 활용할 변수
        
        while (count < N) {
            num++;
            // num에 "666"이 포함되어 있으면 카운팅
            if (Integer.toString(num).contains("666")) {
                count++;
            }
        }

        // N 번째 영화의 제목에 들어갈 수 출력
        System.out.println(num);
    }
}