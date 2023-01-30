/*
 * @author Minyeong Park
 * @date 2023.01.29.
 * 수 정렬하기 4
 * 문제 링크 : https://www.acmicpc.net/problem/11931
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i) + "\n");
        }
        System.out.println(sb);
    }
}