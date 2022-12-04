import java.util.Scanner;

public class 파티가_끝나고_난_뒤 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        
        int people = stdIn.nextInt();
        int area = stdIn.nextInt();
        
        for (int i = 0; i < 5; i++) {
            int article = stdIn.nextInt();
            System.out.printf("%d ", article - (people * area));
        }
        System.out.println();
    }
}