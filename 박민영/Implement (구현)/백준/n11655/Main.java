import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isAlphabetic(c)) {
                char ch = (char) (c + 13);
                if (Character.isLowerCase(c) && ch > 'z') {
                    ch = (char) (ch - 26);
                }
                if (Character.isUpperCase(c) && ch > 'Z') {
                    ch = (char) (ch - 26);
                }
                result += ch;
            } else {
                result += c;
            }
        }
        System.out.println(result);
    }
}