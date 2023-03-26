import java.util.Scanner;

public class Next_in_line {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int youngest = stdIn.nextInt();
        int middle = stdIn.nextInt();
        
        System.out.println(middle + middle - youngest);

        stdIn.close();
    }
}