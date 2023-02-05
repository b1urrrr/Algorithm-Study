import java.io.*;

public class 방학_숙제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        if (A % a == 0)
            A = A / a;
        else
            A = A / a + 1;

        if (B % b == 0)
            B = B / b;
        else
            B = B / b + 1;

        int max = Math.max(A, B);

        System.out.println(L - max);

        br.close();
    }
}