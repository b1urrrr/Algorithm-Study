import java.io.*;
import java.util.*;

public class 럭비_클럽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String input = br.readLine();
            if (input.equals("# 0 0")) break;

            StringTokenizer st = new StringTokenizer(input);
            String name = st.nextToken(); // 이름 입력
            int age = Integer.parseInt(st.nextToken()); // 나이 입력
            int weight = Integer.parseInt(st.nextToken()); // 몸무게 입력

            if (age > 17 || weight >= 80) bw.write(name + " Senior\n");
            else bw.write(name + " Junior\n");
        }

        bw.flush();
    }
}