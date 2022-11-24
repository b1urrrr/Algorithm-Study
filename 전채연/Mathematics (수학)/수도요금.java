import java.io.*;

public class 수도요금 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int d = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        int min; 

        if (c < p)
            min = (p - c) * d + b;
        else min = b;

        min = Math.min(min, a * p);

        System.out.println(min);
    }
}