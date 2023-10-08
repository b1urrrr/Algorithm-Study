/*
 * @author Minyeong Park
 * @date 2023.10.08.
 * 대지
 * 문제 링크 : https://www.acmicpc.net/problem/9063
 */



import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int max_x = -10001;
        int min_x = 10001;
        int max_y = -10001;
        int min_y = 10001;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x > max_x) max_x = x;
            if (x < min_x) min_x = x;
            if (y > max_y) max_y = y;
            if (y < min_y) min_y = y;
        }

        System.out.println((max_x - min_x) * (max_y - min_y));
    }
}