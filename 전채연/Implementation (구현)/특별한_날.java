import java.io.*;

public class 특별한_날 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());
        String result;

        if (month == 2) {
            if (day == 18) result = "Special";
            else if (day < 18) result = "Before";
            else result = "After"; 
        } else if (month < 2) result = "Before";
        else result = "After";

        System.out.println(result);
    }
}