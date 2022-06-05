// chap04 (1) 예제 4-1 : 상하좌우 (내가 푼 코드)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n4_1_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int row = 1;
        int col = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            String ch = st.nextToken();
            if (ch.equals("L")) {
                if (col - 1 > 1)
                    col--;
            } else if (ch.equals("R")) {
                if (col + 1 < N)
                    col++;
            } else if (ch.equals("U")) {
                if (row - 1 > 1)
                    row--;
            } else {
                if (row + 1 < N)
                    row++;
            }
        }

        System.out.println(row + " " + col);
    }
}
