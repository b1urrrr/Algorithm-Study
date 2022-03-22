import java.io.*;

public class 하노이_탑_이동_순서 {
    static int count = 0;
    static String[] s = new String[1048575];

    static void hanoi(int num, int start, int end) {
        if (num == 1) {
            count++;
            s[count - 1] = start + " " + end + "\n";
            return;
        }
        hanoi(num - 1, start, 6 - start - end);
        count++;
        s[count - 1] = start + " " + end + "\n";
        hanoi(num - 1, 6 - start - end, end);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());


        hanoi(N, 1, 3);
        bw.write(count + "\n");
        for (int i = 0; i < count; i++) {
            bw.write(s[i]);
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
