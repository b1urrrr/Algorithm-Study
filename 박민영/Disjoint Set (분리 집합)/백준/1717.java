/*
 * @author Minyeong Park
 * @date 2023.03.23.
 * 집합의 표현
 * 문제 링크 : https://www.acmicpc.net/problem/1717
 */


import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = i; // 자기 자신 인덱스로 저장
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            switch (flag) {
                case 0:
                    union(a,b);
                    break;
                case 1:
                    if (checkSame(a,b)) {
                        System.out.println("yes");
                    } else {
                        System.out.println("no");
                    }
                    break;
            }
        }
    }

    static void union(int a, int b) {
        // 대표 노드를 찾아서 연결
        a = find(a);
        b = find(b);
        if (a != b) {
            arr[b] = a; // 두 개를 연결함
        }
    }

    static int find(int a) {
        if (arr[a] == a) {
            return a;
        } else  {
            return arr[a] = find(arr[a]); // value를 index로 바꿔서 또 찾아보기 // 꼭 배열에 넣어줘야 경로압축이다!
        }
    }

    static boolean checkSame(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return true;

        return false;
    }
}