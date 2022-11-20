import java.io.*;
import java.util.StringTokenizer;

public class 심준의_병역판정검사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double height = Double.parseDouble(st.nextToken());
            double weight = Double.parseDouble(st.nextToken());
            double bmi = weight / Math.pow(height * 0.01, 2);

            if (height < 140.1) System.out.println(6);
            else if (height < 146) System.out.println(5);
            else if (height < 159) System.out.println(4);
            else if (height < 161) {
                if (bmi >= 16 && bmi < 35) System.out.println(3);
                else System.out.println(4);
            } else if (height < 204) {
                if (bmi >= 20 && bmi < 25) System.out.println(1);
                else if (bmi >= 18.5 && bmi < 30) System.out.println(2);
                else if (bmi >= 16 && bmi < 35) System.out.println(3);
                else System.out.println(4);
            } else System.out.println(4);
        }
    }
}