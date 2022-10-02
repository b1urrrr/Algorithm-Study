/*
 * @author Minyeong Park
 * @date 2022.10.01.
 * 국영수
 * 참고 : https://www.acmicpc.net/board/view/29853
 * 문제 링크 : https://www.acmicpc.net/problem/10825
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        String[][] grade = new String[n][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                grade[i][j] = st.nextToken();
            }
        }

        Arrays.sort(grade, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[1].equals(o2[1])) {
                    if (o1[2].equals(o2[2])) {
                        if (o1[3].equals(o2[3])) {
                            int min_length = Math.min(o1[0].length(), o2[0].length());
                            for (int i = 0; i < min_length; i++) {
                                if (o1[0].charAt(i) == o2[0].charAt(i)) {
                                    continue;
                                } else {
                                    return o1[0].charAt(i) - o2[0].charAt(i);
                                }
                            }
                        }
                        return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
                    }
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                }
                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(grade[i][0]).append("\n");
        }
        System.out.println(sb);
    }
}