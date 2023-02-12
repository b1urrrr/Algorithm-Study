/*
 * @author Minyeong Park
 * @date 2023.02.08.
 * 스위치 켜고 끄기
 * 문제 링크 : https://www.acmicpc.net/problem/1244
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] switches;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        switches = new int[n+1];
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }

        int student_count = Integer.parseInt(br.readLine());
        for (int i = 0; i < student_count; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int num;
            switch (sex) {
                case 1:
                    num = Integer.parseInt(st.nextToken());
                    change_1(num);
                    break;
                case 2:
                    num = Integer.parseInt(st.nextToken());
                    change_2(num);
                    break;
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (++count > 20) {
                count = 1;
                System.out.println();
                System.out.print(switches[i] + " ");
            } else {
                System.out.print(switches[i] + " ");
            }
        }
    }

    static void change_1(int num) {
        for (int i = num; i <= n; i += num) {
            switches[i] = (switches[i] == 0) ? 1 : 0;
        }
    }

    static void change_2(int num) {
        switches[num] = (switches[num] == 0) ? 1 : 0;
        for (int i = 1; num - i >= 1 && num + i <= n; i++) {
            if (switches[num - i] == switches[num + i]) {
                switches[num - i] = switches[num + i] = (switches[num + i] == 0) ? 1 : 0;
            } else {
                break;
            }
        }
    }
}