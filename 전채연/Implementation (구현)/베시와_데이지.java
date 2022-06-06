/*
    백준 16431번 : 베시와 데이지
    - 문제 유형 : 구현
*/

import java.io.*;
import java.util.StringTokenizer;

public class 베시와_데이지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int bx = Integer.parseInt(st.nextToken());
        int by = Integer.parseInt(st.nextToken());

        s = br.readLine();
        st = new StringTokenizer(s);
        int dx = Integer.parseInt(st.nextToken());
        int dy = Integer.parseInt(st.nextToken());

        s = br.readLine();
        st = new StringTokenizer(s);
        int jx = Integer.parseInt(st.nextToken());
        int jy = Integer.parseInt(st.nextToken());

        bx = Math.abs(jx - bx);
        by = Math.abs(jy - by);
        int min = Math.min(bx, by);
        int max = Math.max(bx, by) - min;
        int bessie = min + max;
        int daisy = Math.abs(jx - dx) + Math.abs(jy - dy);

        if (bessie < daisy) System.out.println("bessie");
        else if (bessie > daisy) System.out.println("daisy");
        else System.out.println("tie");
    }
}