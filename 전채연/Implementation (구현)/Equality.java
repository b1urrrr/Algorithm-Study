import java.io.*;

public class Equality {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String answer = br.readLine();

        int a = answer.charAt(0) - '0';
        int b = answer.charAt(4) - '0';
        int c = answer.charAt(8) - '0';

        if (a + b == c) System.out.println("YES");
        else System.out.println("NO");
    }
}