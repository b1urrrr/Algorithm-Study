import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String[] words = sentence.split(" ");
        int answer = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals("")) {
                answer--;
            }
        }
        System.out.print(answer);
    }
}
