import java.io.*;
import java.util.*;

public class Contest_Timing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken()); // 대회를 마친 일 입력
        int H = Integer.parseInt(st.nextToken()); // 대회를 마친 시 입력
        int M = Integer.parseInt(st.nextToken()); // 대회를 마친 분 입력

        if (D > 11) {
            int result = (D - 12) * 24 * 60;
            result += (H * 60) + M + 769;
            System.out.println(result);
        } 
        else if (D == 11 && H > 11) {
            int result = 49 + (H - 12) + M;
            System.out.println(result);
        }
        else if (D == 11 && H == 11 && M >= 11) System.out.println(M - 11);
        else System.out.println(-1);
    }
}