/*
 * @author Minyeong Park
 * @date 2023.03.27.
 * 타임머신
 * 참고 출처 : https://tang25.tistory.com/entry/%EB%B0%B1%EC%A4%80-11657%EB%B2%88-%ED%83%80%EC%9E%84%EB%A8%B8%EC%8B%A0-%EA%B7%B8%EB%9E%98%ED%94%84-%EB%B2%A8%EB%A7%8C-%ED%8F%AC%EB%93%9C-%EC%9E%90%EB%B0%94
 * 문제 링크 : https://www.acmicpc.net/problem/11657
 */


import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static ArrayList<City> list;
    static long[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.add(new City(a, b, c));
        }

        time = new long[n + 1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[1] = 0;

        if (bellmanFord(time)) {
            System.out.println(-1);
            return;
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i < time.length; i++) {
                if (time[i] == Integer.MAX_VALUE) {
                    sb.append(-1 + "\n");
                } else {
                    sb.append(time[i] + "\n");
                }
            }
            System.out.println(sb);
        }


    }

    static boolean bellmanFord(long[] time) {
        boolean isMinusCycle = false;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                City now = list.get(j);

                if (time[now.start] == Integer.MAX_VALUE) {
                    continue;
                }

                if (time[now.end] > time[now.start] + now.weight) {
                    time[now.end] = time[now.start] + now.weight;

                    if (i == n) { // 전체 한번 다 돌고(0 ~ n) 한번 더 돌았을 때에도 최단거리 갱신이 일어나면 그건 음수 사이클이 있는 것임
                        isMinusCycle = true;
                        break;
                    }
                }
            }
        }

        return isMinusCycle;
    }
}

class City {
    int start;
    int end;
    int weight;

    public City(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}