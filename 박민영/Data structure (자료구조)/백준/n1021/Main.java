/*
 * @author Minyeong Park
 * @date 2022.11.13.
 * 회전하는 큐
 * 문제 링크 : https://www.acmicpc.net/problem/1021
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i+1);
        }

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int now_num = Integer.parseInt(st.nextToken());
            int now_idx = 0;
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(j) == now_num) {
                    now_idx = j;
                }
            }

            int temp_cnt;
            boolean dequeue_front;
            if (now_idx <= arrayList.size() - now_idx) {
                temp_cnt = now_idx;
                dequeue_front = true;
            } else {
                temp_cnt = arrayList.size() - now_idx;
                dequeue_front = false;
            }

            if (dequeue_front) {
                for (int j = 0; j < temp_cnt; j++) {
                    int removed = arrayList.remove(0);
                    arrayList.add(removed);
                    cnt++;
                }
            } else {
                for (int j = 0; j < temp_cnt; j++) {
                    int removed = arrayList.remove(arrayList.size() - 1);
                    arrayList.add(0, removed);
                    cnt++;
                }
            }

            arrayList.remove(0);
        }

        System.out.println(cnt);
    }
}