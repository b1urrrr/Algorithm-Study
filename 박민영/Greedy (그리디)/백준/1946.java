/*
 * @author Minyeong Park
 * @date 2023.04.02.
 * 신입사원
 * 참고 : https://www.acmicpc.net/board/view/43148, https://dundung.tistory.com/69
 * 문제 링크 : https://www.acmicpc.net/problem/1946
 */


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Applicant {
    int doc_rank;
    int meet_rank;

    public Applicant(int doc_grade, int meet_grade) {
        this.doc_rank = doc_grade;
        this.meet_rank = meet_grade;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());


        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());

            ArrayList<Applicant> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int d = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());

                list.add(new Applicant(d, m));
            }

            Collections.sort(list, new Comparator<Applicant>() {
                @Override
                public int compare(Applicant o1, Applicant o2) {
                    return o1.doc_rank - o2.doc_rank;
                }
            });

            int cnt = 1; // 서류 1등은 자동으로 합격이므로 cnt을 1로 시작함
            int best_meet = list.get(0).meet_rank; // 제일 높은 면접 순위 // 일단은 서류 1등의 면접 순위로 설정
            for (Applicant a : list) { // 서류 2등부터 탐색
                if (a.meet_rank < best_meet) { // 더 높은 순위를 발견하면 best_meet 갱신
                    cnt++;
                    best_meet = a.meet_rank;
                }
            }
            System.out.println(cnt);
        }
    }
}