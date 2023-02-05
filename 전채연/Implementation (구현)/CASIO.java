import java.io.*;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class CASIO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s);
        BigInteger student = new BigInteger(st.nextToken());
        BigInteger teacher = new BigInteger(st.nextToken());

        if (student.compareTo(teacher) == 0) System.out.println("1");
        else System.out.println("0");
    }
}