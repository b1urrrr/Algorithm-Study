/*
 * @author Minyeong Park
 * @date 2023.01.22.
 * N번째 큰 수
 * 문제 링크 : https://www.acmicpc.net/problem/2693
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
            int count = st.countTokens();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                arr.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(arr, Collections.reverseOrder());
            System.out.println(arr.get(2));
        }
    }
}