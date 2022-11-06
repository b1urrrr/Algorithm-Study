import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        int[] alphabet = new int[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = 0;
        }
        for (int i = 0; i < word.length(); i++) {
            int ascii = (int) word.charAt(i);
            if (ascii >= 97) {
                ascii -= 97;
            } else {
                ascii -= 65;
            }
            alphabet[ascii]++;
        }
        boolean isdupe = false;
        int max = 0;
        for (int i = 1; i < alphabet.length; i++) {
            if (alphabet[max] < alphabet[i]) {
                isdupe = false;
                max = i;
            } else if (alphabet[max] == alphabet[i]) {
                isdupe = true;
            }
        }
        if (isdupe) {
            System.out.print("?");
        } else {
            System.out.print((char) (max + 65));
        }
    }
}
