/*
 * @author Minyeong Park
 * @date 2023.09.24.
 * 삼각형과 세 변
 * 문제 링크 : https://www.acmicpc.net/problem/5073
 */


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        while (true) {
            line = br.readLine();
            if (line.equals("0 0 0"))
                break;

            st = new StringTokenizer(line);
            int[] tri = new int[3];
            tri[0] = Integer.parseInt(st.nextToken());
            tri[1] = Integer.parseInt(st.nextToken());
            tri[2] = Integer.parseInt(st.nextToken());

            Arrays.sort(tri);

            if (tri[2] >= tri[0] + tri[1]) {
                System.out.println("Invalid");
            } else if (tri[0] == tri[1] && tri[0] == tri[2]) {
                System.out.println("Equilateral");
            } else if (tri[0] == tri[1] || tri[0] == tri[2] || tri[1] == tri[2]){
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}