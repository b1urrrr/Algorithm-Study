/*
 * @author Minyeong Park
 * @date 2023.04.09.
 * 종이자르기 (정렬로 푸는 풀이)
 * 코드 참고 : https://sungone-develop-study.tistory.com/m/entry/%EB%B0%B1%EC%A4%802628-%EC%A2%85%EC%9D%B4-%EC%9E%90%EB%A5%B4%EA%B8%B0-java
 * 문제 링크 : https://www.acmicpc.net/problem/2628
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int col_cnt = Integer.parseInt(st.nextToken());
        int row_cnt = Integer.parseInt(st.nextToken());
        ArrayList<Integer> garolist = new ArrayList<>();
        ArrayList<Integer> serolist = new ArrayList<>();
        garolist.add(0);
        serolist.add(0);

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 0) {
                garolist.add(Integer.parseInt(st.nextToken()));
            } else {
                serolist.add(Integer.parseInt(st.nextToken()));
            }
        }
        garolist.add(row_cnt);
        serolist.add(col_cnt);
        Collections.sort(garolist);
        Collections.sort(serolist);

        ArrayList<Integer> box = new ArrayList<>(); // 사각형 넓이 저장할 리스트

        for (int i = 1; i < garolist.size(); i++) {
            int nowsero = garolist.get(i) - garolist.get(i - 1);

            for (int j = 1; j < serolist.size(); j++) {
                int nowgaro = serolist.get(j) - serolist.get(j - 1);

                box.add(nowgaro * nowsero);
            }
        }

        Collections.sort(box);
        System.out.println(box.get(box.size() - 1));
    }
}