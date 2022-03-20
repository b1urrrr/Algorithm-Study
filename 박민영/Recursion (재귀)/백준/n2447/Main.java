/*
 * @author Minyeong Park
 * @date 2022.03.17. & 03.20.
 * 별 찍기 - 10 (다른 분의 원리/코드를 이해하면서 풀었습니다...)
 * 참고한 글 : https://st-lab.tistory.com/95
 * https://www.acmicpc.net/problem/2447
 */


import java.io.*;

public class Main {
    static char[][] arr;   // 별 or 공백 출력 여부를 담는 배열 (전역변수로 설정해서 메인함수에서도 이용 가능하게 함)
    static void star (int x, int y, int N, boolean blank) { // x : x좌표, y : y좌표, N : 블록의 크기, blank : 공백칸 여부
        // 공백칸일 경우
        if (blank) {
            for (int i = x; i < x + N; i++) {  // 공백칸일 경우 1칸 사이즈 크기만큼을 공백으로 채움
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        // 더 이상 쪼갤 수 없는 블록일 때
        if (N == 1) {
            arr[x][y] = '*'; // N이 1이면 빈칸 없이 그냥 *만 출력
            return;
        }

        int size = N/3; // 해당 블록의 한 칸을 담을 변수를 의미하는 변수
        int count = 0;  // 출력 칸을 세는 누적 값
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count ++;
                if (count == 5) { // 공백 칸일 경우 (3*3 = 9칸 중 5번째 칸이 공백칸!)
                    star(i, j, size, true);
                }
                else {
                    star(i, j, size, false);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        arr = new char[num][num];
        star(0,0,num,false); // arr 배열에 별 또는 공백 값으로 채워넣기
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                bw.write(arr[i][j]);
            }
            bw.write('\n');
        }
        bw.flush();
    }
}