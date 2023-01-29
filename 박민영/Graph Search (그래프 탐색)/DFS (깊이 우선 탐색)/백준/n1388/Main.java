/*
 * @author Minyeong Park
 * @date 2023.01.29.
 * 바닥 장식
 * 원리 및 참고 출처 : https://www.acmicpc.net/board/view/93075, https://codesign.tistory.com/5
 * 문제 링크 : https://www.acmicpc.net/problem/1388
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] map;
    static boolean[][] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
//            map[i] = br.readLine().toCharArray(); // 이렇게 string -> char 배열 로 변환도 가능!
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // '-' 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '-') {
                    count++;
                    for (; j < m; j++) {
                        if (map[i][j] != '-')
                            break;
                    }
                }
            }
        }

        // '|' 탐색
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (map[i][j] == '|') {
                    count++;
                    for (; i < n; i++) {
                        if (map[i][j] != '|')
                            break;
                    }
                }
            }
        }

        System.out.println(count);
    }
}