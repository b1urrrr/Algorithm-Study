/*
    백준 16199번 : 나이 계산하기
    - 문제 유형 : 구현
*/

import java.io.*;
import java.util.StringTokenizer;

public class 나이_계산하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int birthY = Integer.parseInt(st.nextToken());
        int birthM = Integer.parseInt(st.nextToken());
        int birthD = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int todayY = Integer.parseInt(st.nextToken());
        int todayM = Integer.parseInt(st.nextToken());
        int todayD = Integer.parseInt(st.nextToken());

        int z = todayY - birthY;
        int y = z + 1;
        int x = z;
        if (todayM < birthM) {
            x--;
        } else if (todayM == birthM) {
            if (todayD < birthD) {
                x--;
            }
        }

        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
    }
}