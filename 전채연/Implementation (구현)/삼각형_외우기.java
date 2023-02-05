import java.io.*;

public class 삼각형_외우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int angle1 = Integer.parseInt(br.readLine());
        int angle2 = Integer.parseInt(br.readLine());
        int angle3 = Integer.parseInt(br.readLine());
        String result;

        if (angle1 + angle2 + angle3 != 180) result = "Error";
        else if (angle1 == angle2 && angle2 == angle3) result = "Equilateral";
        else if (angle1 == angle2 || angle1 == angle3 || angle2 == angle3) result = "Isosceles";
        else result = "Scalene";

        System.out.println(result);
    }
}