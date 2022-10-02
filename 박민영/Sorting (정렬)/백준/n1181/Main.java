/*
 * @author Minyeong Park
 * @date 2022.03.27.
 * 단어 정렬
 * 문제 링크 : https://www.acmicpc.net/problem/1181
 */


import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] str_arr = new String[N];
        for (int i = 0; i < N; i++) {
            str_arr[i] = br.readLine();
        }

        Arrays.sort(str_arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) > o2.charAt(i))
                            return 1;
                        else if (o1.charAt(i) == o2.charAt(i)) {
                            if (i == o1.length() - 1) return 0;
                            else continue;
                        }
                        else return -1;
                    }
                }
                return o1.length() - o2.length();
            }
        });

        boolean[] flag_arr = new boolean[N]; // 같은 단어이면 뒤의 것은 false로 나타냄
        Arrays.fill(flag_arr, true);     // 일단 모두 true로 설정
        for (int i = 0; i < N - 1; i++) {
            if (str_arr[i].equals(str_arr[i+1]))
                flag_arr[i+1] = false;
        }

        for (int i = 0; i < N; i++) {
            if (flag_arr[i] == false)
                continue;
            else bw.write(str_arr[i] + "\n");
        }
        bw.flush();
    }
}