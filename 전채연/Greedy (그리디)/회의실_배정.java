/*
    백준 1931번 : 회의실 배정
    - 문제 유형 : 그리디 알고리즘
*/

import java.util.Comparator;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.*;

public class 회의실_배정 {
    // 회의실 사용 시작 시간과 끝 시간을 저장하는 클래스
    static class Room {
        private int start;
        private int end;

        public Room(int s, int e) {
            this.start = s;
            this.end = e;
        }

        public int getStart() {
            return this.start;
        }

        public int getEnd() {
            return this.end;
        }
    }

    // Comparator 구현 : 끝 시간의 오름차순, 끝 시간이 같다면 시작 시간의 오름차순
    public static class Comp implements Comparator<Room> {
        public int compare(Room r1, Room r2) {
            if (r1.getEnd() > r2.getEnd()) return 1;
            else if (r1.getEnd() < r2.getEnd()) return -1;
            else if (r1.getStart() > r2.getStart()) return 1;
            else  return -1;
        }
    }

    // Comparator 객체
    public static final Comparator<Room> COMPARATOR = new Comp();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 회의의 수 N 입력
        Room[] rooms = new Room[N]; // 회의 저장 배열

        for (int i = 0; i < N; i++) {
            String s = br.readLine(); // 회의의 시작 시간과 끝 시간 입력
            StringTokenizer st = new StringTokenizer(s);
            rooms[i] = new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        // COMPARATOR 기준으로 회의 정렬
        Arrays.sort(rooms, COMPARATOR);

        int count = 1; // 회의실 사용이 가능한 회의의 수
        int former = 0; // 이전에 회의실을 사용한 회의의 인덱스
        for (int i = 1; i < N; i++) {
            // 이전의 회의가 끝나는 시간과 같거나 늦게 시작하는 회의면 회의실 사용 가능
            if (rooms[former].getEnd() <= rooms[i].getStart()) {
                count++;
                former = i;
            }
        }

        // 회의실 사용이 가능한 회의의 수 출력
        System.out.println(count);
    }
}