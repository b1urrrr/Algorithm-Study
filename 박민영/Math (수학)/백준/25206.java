/*
 * @author Minyeong Park
 * @date 2023.03.05.
 * 너의 평점은
 * 문제 링크 : https://www.acmicpc.net/problem/25206
 */



import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringTokenizer st;
        double grade_sum = 0.0;
        double size_sum = 0.0;
        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double size = Double.parseDouble(st.nextToken());
            double grade = 0.0;
            String grade_str = st.nextToken();
            switch (grade_str) {
                case "A+":
                    grade = 4.5;
                    break;
                case "A0":
                    grade = 4.0;
                    break;
                case "B+":
                    grade = 3.5;
                    break;
                case "B0":
                    grade = 3.0;
                    break;
                case "C+":
                    grade = 2.5;
                    break;
                case "C0":
                    grade = 2.0;
                    break;
                case "D+":
                    grade = 1.5;
                    break;
                case "D0":
                    grade = 1.0;
                    break;
                case "F":
                    grade = 0.0;
                    break;
                case "P":
                    break;
            }

            if (!grade_str.equals("P")) {
                grade_sum += size * grade;
                size_sum += size;
            }
        }

        System.out.println(grade_sum / size_sum);
    }
}