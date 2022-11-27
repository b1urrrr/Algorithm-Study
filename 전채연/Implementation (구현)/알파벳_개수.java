import java.io.*;

public class 알파벳_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine(); // 단어 S 입력
        int[] alphabet = new int[26];
        
        for (int i = 0; i < S.length(); i++) {
            alphabet[S.charAt(i) - 'a']++; // 해당 알파벳 개수 증가
        }

        for (int i = 0; i < 26; i++) {
            System.out.print(alphabet[i] + " "); // i 번째 알파벳 개수 출력
        }
        System.out.println();
    }
}