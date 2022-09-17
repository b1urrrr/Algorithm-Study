/*
 * @author Minyeong Park
 * @date 2022.09.17.
 * 요세푸스 문제
 * 문제 링크 : https://www.acmicpc.net/problem/1158
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            arrayList.add(i);
        }

        System.out.print("<");
        int index = 0;
        while (!arrayList.isEmpty()) {
            index += k - 1;
            while (index >= arrayList.size()) {
                index -= arrayList.size();
            }
            int removed = arrayList.remove(index);
            if (arrayList.isEmpty()) {
                System.out.println(removed + ">");
                break;
            }
            System.out.print(removed + ", ");
        }
    }
}