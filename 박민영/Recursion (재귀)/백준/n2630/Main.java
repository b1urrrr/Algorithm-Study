/*
 * @author Minyeong Park
 * @date 2022.03.20.
 * 색종이 만들기 (막혀서 다른 분의 원리와 코드를 보면서 조금씩 구현해보고 수정하면서 해결했습니다..)
 * 참고한 글 : https://st-lab.tistory.com/227
 * https://www.acmicpc.net/problem/2630
 */


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] paper;
    static int white = 0; // 화이트 사각형의 개수
    static int blue = 0;  // 블루 사각형의 개수


    static void slice_paper(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (paper[row][col] == 1) {
                blue++;
            } else {
                white++;
            }
            return;
        }

        size = size / 2; // 사이즈 절반으로 줄임

        slice_paper(row, col, size);                         // 분할된 2사분면 (왼쪽 위)
        slice_paper(row, col + size, size);              // 분할된 1사분면 (오른쪽 위)
        slice_paper(row + size, col, size);             // 분할된 3사분면
        slice_paper(row + size, col + size, size);  // 분할된 4사분면
    }

    static boolean colorCheck(int row, int col, int size) {
        int color = paper[row][col]; // 현재 구역의 첫번째 원소의 색깔 (이것을 기준으로 검사함)

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != color)
                    return false;
            }
        }
        return true; // 검사를 모두 통과했으므로 모두 색깔이 같다는 의미!
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        paper = new int[num][num];

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < num; j++)
                paper[i][j] = Integer.parseInt(st.nextToken());
        }

        slice_paper(0,0,num);
        bw.write(white + "\n");
        bw.write(blue + "");
        bw.flush();
    }
}