/*
 * @author Minyeong Park
 * @date 2022.06.19.
 * 어린 왕자
 * 원리 참고 : https://cocoon1787.tistory.com/350
 * 문제 링크 : https://www.acmicpc.net/problem/1004
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            int count = 0;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                if (Math.pow(x1-cx,2) + Math.pow(y1-cy,2) < Math.pow(r,2) && Math.pow(x2-cx,2) + Math.pow(y2-cy,2) < Math.pow(r,2))
                    continue;
                if (Math.pow(x1-cx,2) + Math.pow(y1-cy,2) < Math.pow(r,2))
                    count++;
                if (Math.pow(x2-cx,2) + Math.pow(y2-cy,2) < Math.pow(r,2))
                    count++;

//                // 또는 (다른 코드 참고)
//                if (Math.pow(x1-cx,2) + Math.pow(y1-cy,2) < Math.pow(r,2))
//                    if (Math.pow(x2-cx,2) + Math.pow(y2-cy,2) > Math.pow(r,2))
//                        count++;
//                if (Math.pow(x1-cx,2) + Math.pow(y1-cy,2) > Math.pow(r,2))
//                    if (Math.pow(x2-cx,2) + Math.pow(y2-cy,2) < Math.pow(r,2))
//                        count++;
            }
            System.out.println(count);
        }
    }
}