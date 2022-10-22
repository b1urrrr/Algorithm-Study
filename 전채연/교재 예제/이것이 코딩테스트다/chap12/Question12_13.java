package chap12;

import java.io.*;
import java.util.*;

public class Question12_13 {
    static int N, M, result = Integer.MAX_VALUE;
    static int[][] city;
    static ArrayList<Location> houses = new ArrayList<>();
    static ArrayList<Location> stores = new ArrayList<>();

    static class Location {
        int x;
        int y;
        boolean isOpen;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
            this.isOpen = true;
        }
    }

    static void calculateDistance() {
        int sum = 0;
        for (int i = 0; i < houses.size(); i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < stores.size(); j++) {
                if (!stores.get(j).isOpen) continue;
                int distance = Math.abs(houses.get(i).x - stores.get(j).x) + Math.abs(houses.get(i).y - stores.get(j).y);
                min = Math.min(min, distance);
            }
            sum += min;
        }
        result = Math.min(result, sum);
    }

    // 치킨집 폐업 함수
    static void close(int depth, int index) {
        // M개를 제외한 치킨집을 폐업시킨 경우
        if (depth == stores.size() - M) {
            calculateDistance();
            return;
        }

        for (int i = index; i < stores.size(); i++) {
            // 이미 닫혀있는 경우 무시
            if (!stores.get(i).isOpen) continue;

            stores.get(i).isOpen = false;
            close(depth + 1, i + 1);
            stores.get(i).isOpen = true;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 도시의 크기 N 입력
        M = Integer.parseInt(st.nextToken()); // 남을 치킨집의 개수 M 입력
        city = new int[N + 1][N + 1];

        // 도시의 정보 입력
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken()); // 도시의 정보 입력
                // 집인 경우
                if (city[i][j] == 1) houses.add(new Location(i, j));
                // 치킨집인 경우
                else if (city[i][j] == 2) stores.add(new Location(i, j));
            }
        }

        close(0, 0);

        // 도시의 치킨 거리의 최솟값 출력
        System.out.println(result);
    }
}