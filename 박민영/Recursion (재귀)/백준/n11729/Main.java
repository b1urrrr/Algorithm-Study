/*
 * @author Minyeong Park
 * @date 2022.03.30.& 04.01.
 * 하노이 탑 이동 순서 (참고하면서 풀었습니다)
 * 참고한 글 : https://st-lab.tistory.com/96
 * 문제 링크 : https://www.acmicpc.net/problem/11729
 */


import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void hanoi (int N, int start, int mid, int end) throws IOException {
        // 그룹(큰 원반이 아닌 원반들)을 중간 기둥으로 옮겨야!
        //    그룹을 시작기둥 -> 중간기둥
        // 큰 원반을 시작기둥 -> 목표기둥
        //   그룹을 중간기둥 -> 목표기둥

        // start : 출발지
        // mid : 옮기기 위해 이동해야 할 장소
        // end : 목적지

        // 이동할 원반의 수가 1개라면?
        if (N == 1) {
            bw.write(start + " " + end + "\n");
            return;
        }

        // 1) N-1개를 시작 기둥 -> 중간 기둥
        hanoi(N-1, start, end, mid);          // start지점의 N-1개를 mid 지점으로 옮긴다!

        // 2) 1개(큰 원판)를 시작 기둥 -> 목표 기둥
        bw.write(start + " " + end + "\n");  // start지점의 N번째 원판을 end 지점으로 옮긴다

        // 3) N-1개를 중간 기둥 -> 목표 기둥
        hanoi(N-1, mid, start, end);         // mid지점의 N-1개 원판을 end 지점으로 옮긴다
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        bw.write((int) (Math.pow(2,N) - 1) + "\n"); // 몇 번 옮겼는지 (n+1번째 = 2 * (n번째) + 1)
        hanoi(N, 1, 2, 3);

        bw.flush();
    }
}