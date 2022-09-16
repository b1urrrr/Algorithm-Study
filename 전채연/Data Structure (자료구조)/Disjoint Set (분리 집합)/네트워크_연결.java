/*
    백준 3780번 : 네트워크 연결
    - 문제 유형 : 자료구조, 분리 집합
*/

import java.io.*;
import java.util.*;

public class 네트워크_연결 {
    static int N; // 기업의 수 N
    static int[] parent, len; // 부모 노드 배열

    // 부모 노드 탐색 함수
    static int find(int a) {
        if (parent[a] == a) return a;
        int p = find(parent[a]);
        // a에서 센터까지의 거리 추가
        len[a] += len[parent[a]];
        return parent[a] = p;
    }

    // 네트워크 연결 함수
    static void union(int a, int b) {
        parent[a] = b;
        len[a] = Math.abs((a - b) % 1000);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수 입력

        // 테스트 케이스 반복
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            parent = new int[N + 1];
            len = new int[N + 1];

            // 부모 노드 배열 자기 자신으로 초기화
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken(); // 명령어 입력

                // O가 입력되면 테스트 케이스 종료
                if (command.equals("O")) break;

                switch (command) {
                    case "E": // E I – 기업 I와 현재 I의 센터까지의 거리 출력
                        int i = Integer.parseInt(st.nextToken());
                        find(i);
                        bw.write(len[i] + "\n");
                        bw.flush();
                        break;
                    case "I": // I I J – 센터 I를 기업 J에 연결
                        int I = Integer.parseInt(st.nextToken());
                        int J = Integer.parseInt(st.nextToken());
                        union(I, J);
                        break;
                    default:
                }
            }
        }
    }
}