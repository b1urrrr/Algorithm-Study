import java.io.*;
import java.util.StringTokenizer;

public class 손익분기점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        int fixed = Integer.parseInt(st.nextToken());
        int variable = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());

        if (variable >= cost)
            System.out.println(-1);
        else
            System.out.println(fixed / (cost - variable) + 1);
    }
}