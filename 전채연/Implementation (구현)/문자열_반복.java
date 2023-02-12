import java.util.Scanner;

public class 문자열_반복 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            String answer = "";
            int repeat = sc.nextInt();
            String word = sc.next();
            for (int j = 0; j < word.length(); j++) {
                for (int k = 0; k < repeat; k++) {
                    answer += word.charAt(j);
                }
            }
            System.out.println(answer);
        }
    }
}
