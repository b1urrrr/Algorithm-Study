/*
 * @author Minyeong Park
 * @date 2022.04.17.
 * 영화감독 숌
 * 문제 링크 : https://www.acmicpc.net/problem/1436
 */

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N_str = br.readLine();
        int N_int = Integer.parseInt(N_str);
        if (N_int == 1) {
            System.out.println("666");
            return;
        }
        if (N_int <= 6) {
            System.out.println((N_int-1) + "666");
            return;
        }
        int count = 6; // 666이 들어가는 수의 개수 (666 ~ 5666까지 6개)
        int i;
        for (i = 6660; count != N_int; i++) {
            if ((i + "").contains("666"))
                count++;
        }
        System.out.println(i - 1); // for문 나올 때 +1 이 되므로 -1 한 후 출력

    }
}