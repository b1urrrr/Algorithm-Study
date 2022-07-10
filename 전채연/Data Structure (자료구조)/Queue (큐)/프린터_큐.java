/*
    백준 1966번 : 프린터 큐
    - 문제 유형 : 자료 구조, 큐, 시뮬레이션
*/

import java.io.*;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class 프린터_큐 {
    static class Document {
        int index; // 문서의 위치 (왼쪽이 0)
        int value; // 문서의 중요도

        Document(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서의 개수
            int M = Integer.parseInt(st.nextToken()); // 문서의 위치
            Queue<Document> que = new LinkedList<>();
            int[] values = new int[10]; // 카운팅 배열

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                que.add(new Document(j, v)); // 큐에 문서 저장
                values[v]++; // 카운팅
            }

            int count = 0;
            A : while (!que.isEmpty()) {
                Document document = que.remove();
                // 중요도가 더 높은 문서가 존재하는 경우
                for (int j = 9; j > document.value; j--) {
                    if (values[j] > 0) {
                        que.add(document);
                        continue A;
                    }
                }

                // 인쇄하는 경우
                values[document.value]--;
                count++;
                if (document.index == M) break;
            }

            // 문서가 몇 번째로 인쇄되는지 출력
            System.out.println(count);
        }
    }    
}
