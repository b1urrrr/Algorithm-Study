/*
    백준 17386번 : 선분 교차 1
    - 문제 유형 : 기하학, 선분 교차 판정
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class 선분_교차_1 {
    /** 좌표 클래스 */
    static class Coordinate {
        BigInteger x;
        BigInteger y;

        public Coordinate(String x, String y) {
            this.x = new BigInteger(x);
            this.y = new BigInteger(y);
        }
    }

    /** 직선 클래스 */
    static class Line {
        Coordinate c1;
        Coordinate c2;

        public Line(Coordinate c1, Coordinate c2) {
            this.c1 = c1;
            this.c2 = c2;
        }
    }

    /** 세 점의 방향 관계가 반시계 방향이면 1 그렇지 않으면 -1 반환 */
    static int ccw(Coordinate c1, Coordinate c2, Coordinate c3) {
        BigInteger s = c1.x.multiply(c2.y).add(c2.x.multiply(c3.y)).add(c3.x.multiply(c1.y));
        s = s.subtract(c1.y.multiply(c2.x).add(c2.y.multiply(c3.x)).add(c3.y.multiply(c1.x)));

        return s.compareTo(BigInteger.ZERO);
    }

    /** 선분 교차 여부 반환 */
    static boolean isIntersect(Line l1, Line l2) {
        int ccw1 = ccw(l1.c1, l1.c2, l2.c1) * ccw(l1.c1, l1.c2, l2.c2);
        int ccw2 = ccw(l2.c1, l2.c2, l1.c1) * ccw(l2.c1, l2.c2, l1.c2);
        return ccw1 < 0 && ccw2 < 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Coordinate c1 = new Coordinate(st.nextToken(), st.nextToken()); // x1, y1 입력
        Coordinate c2 = new Coordinate(st.nextToken(), st.nextToken()); // x2, y2 입력

        st = new StringTokenizer(br.readLine());
        Coordinate c3 = new Coordinate(st.nextToken(), st.nextToken()); // x3, y3 입력
        Coordinate c4 = new Coordinate(st.nextToken(), st.nextToken()); // x4, y4 입력

        Line l1 = new Line(c1, c2);
        Line l2 = new Line(c3, c4);

        // l1과 l2가 교차하면 1, 아니면 0 출력
        if (isIntersect(l1, l2)) System.out.println(1);
        else System.out.println(0);
    }
}