import java.io.*;

public class FYI {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String prefix = br.readLine().substring(0, 3);
        if (prefix.equals("555")) System.out.println("YES");
        else System.out.println("NO");
    }
}
