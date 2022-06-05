/*
 * @author Minyeong Park
 * @date 2022.06.05.
 * 터렛
 * 참고 : https://st-lab.tistory.com/90
 * 문제 링크 : https://www.acmicpc.net/problem/1002
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            System.out.println(cal(x1,y1,r1,x2,y2,r2));
        }
    }

    static int cal(int x1, int y1, int r1, int x2, int y2, int r2) {
        // 두 원의 중심이 같고, 반지름도 같을 때 (접점 개수 무한 개)
        if (x1 == x2 && y1 == y2 && r1 == r2)
            return -1;

        // 두 점 사이의 거리가 각 원의 반지름의 합보다 클 때 (접점이 없는 경우)
        else if (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) > Math.pow(r1 + r2, 2))
            return 0;

        // 한 원 안에 다른 원이 있으면서 접점이 없을 때 (접점이 없는 경우)
        else if (Math.pow(x2-x1,2) + Math.pow(y2-y1,2) < Math.pow(r2-r1,2))
            return 0;

        // 내접할 때 (접점 1개)
        else if (Math.pow(x2-x1,2) + Math.pow(y2-y1,2) == Math.pow(r2-r1,2))
            return 1;

        // 외접할 때 (접점 1개)
        else if (Math.pow(x2-x1,2) + Math.pow(y2-y1,2) == Math.pow(r2+r1,2))
            return 1;

        else
            return 2;
    }
}