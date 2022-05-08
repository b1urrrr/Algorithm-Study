/*
 * @author Minyeong Park
 * @date 2022.05.08.
 * 분수찾기
 * 참고 : https://www.youtube.com/watch?v=bEQq9jvU_Hg
 * 문제 링크 : https://www.acmicpc.net/problem/1193
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int index = 0; // 몇 번째 행에 속하는지를 나타내는 변수
        int sum;       // X번째 분수가 있는 곳의 개수 합

        // 1. X번째가 몇 번째 행에 들어가는지
        while (true) {
            index++;
            sum = index * (index + 1) / 2; // 1 ~ n까지의 합은 n*(n+1) / 2
            if (X <= sum)
                break;
        }

        // 2. 그 행에서 몇 번째 값인지
        int num = X - (index - 1) * index / 2; // X가 있는 행의 이전 행에서의 개수 합을 빼서 몇 번째인지 구함

        // 3. 그 행이 짝수행인지 홀수행인지에 따라 달라짐
        if (index % 2 == 0)
            System.out.printf("%d/%d", num, index - num + 1);
        else
            System.out.printf("%d/%d", index - num + 1, num);
    }
}