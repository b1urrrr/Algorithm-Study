/*
 * @author Minyeong Park
 * @date 2022.10.23.
 * 회사에 있는 사람
 * 문제 링크 : https://www.acmicpc.net/problem/7785
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        HashSet<String> in_com = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String action = st.nextToken();
            if (action.equals("enter")) {
                in_com.add(name);
            } else {
                in_com.remove(name);
            }
        }

        String[] names = new String[in_com.size()];
        int index = 0;
        for (String name : in_com) {
            names[index] = name;
            index++;
        }
        Arrays.sort(names, Comparator.reverseOrder());
        for (String name : names) {
            System.out.println(name);
        }
    }
}