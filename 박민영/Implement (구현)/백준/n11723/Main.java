/*
 * @author Minyeong Park
 * @date 2022.08.08.
 * 집합
 * 문제 링크 : https://www.acmicpc.net/problem/11723
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        boolean[] arr = new boolean[21];

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add" :
                    arr[Integer.parseInt(st.nextToken())] = true;
                    break;
                case "remove" :
                    arr[Integer.parseInt(st.nextToken())] = false;
                    break;
                case "check" :
                    int object = Integer.parseInt(st.nextToken());
                    if (arr[object])
                        sb.append(1).append('\n');
                    else
                        sb.append(0).append('\n');
                    break;
                case "toggle" :
                    object = Integer.parseInt(st.nextToken());
                    arr[object] = !arr[object];
                    break;
                case "all" :
                    Arrays.fill(arr, true);
                    break;
                case "empty" :
                    Arrays.fill(arr, false);
                    break;
            }
        }
        System.out.println(sb);
    }
}