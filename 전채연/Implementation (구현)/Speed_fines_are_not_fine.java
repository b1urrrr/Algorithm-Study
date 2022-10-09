import java.io.*;

public class Speed_fines_are_not_fine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int limit = Integer.parseInt(br.readLine());
        int speed = Integer.parseInt(br.readLine());

        if (limit < speed) {
            int over = speed - limit;
            if (over <= 20) System.out.println("You are speeding and your fine is $100.");
            else if (over <= 30) System.out.println("You are speeding and your fine is $270.");
            else System.out.println("You are speeding and your fine is $500.");
        } else {
            System.out.println("Congratulations, you are within the speed limit!");
        }
    }
}
