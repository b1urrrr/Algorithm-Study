/*
    백준 11723번 : 집합
    - 문제 유형 : 집합, 비트마스크
*/

import java.io.*;
import java.util.StringTokenizer;

public class 집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine()); // 연산의 수 입력
        boolean[] data = new boolean[21]; // 1 ~ 20의 저장 여부

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken()) { // 명령어 입력
                case "add":
                    int add = Integer.parseInt(st.nextToken());
                    if (!data[add]) data[add] = true; // add가 없으면 추가
                    break;
                case "remove":
                    int rmv = Integer.parseInt(st.nextToken());
                    if (data[rmv]) data[rmv] = false; // rmv가 있으면 제거
                    break;
                case "check":
                    int chk = Integer.parseInt(st.nextToken());
                    if (data[chk]) bw.write("1\n"); // chk가 있으면 1 출력
                    else bw.write("0\n"); // chk가 없으면 0 출력
                    break;
                case "toggle":
                    int tgl = Integer.parseInt(st.nextToken());
                    if (data[tgl]) data[tgl] = false; // tgl이 있으면 제거
                    else data[tgl] = true; // tgl이 없으면 추가
                    break;
                case "all":
                    for (int j = 1; j < 21; j++) data[j] = true; // 1 ~ 20 추가
                    break;
                case "empty":
                    for (int j = 1; j < 21; j++) data[j] = false; // 1 ~ 20 제거
                    break;
            }
        }

        bw.flush();
    }
}
