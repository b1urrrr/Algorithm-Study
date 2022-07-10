import java.io.*;
import java.util.HashSet;

public class B_PolycarpWritesAStringFromMemory {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String sentence = br.readLine();

            int count = 0;
            int result = 0;
            HashSet<Character> set = new HashSet<>(); 
            for (int j = 0; j < sentence.length(); j++) {
                // 이미 외운 글자면 계속 진행
                if (set.contains(sentence.charAt(j))) continue;
                
                // 글자 3개를 외웠으면 종료
                if (count >= 3) {
                    result++;
                    set.clear();
                    count = 0;
                }
                
                set.add(sentence.charAt(j));
                count++;
            }

            if (count > 0) result++;
            System.out.println(result);
        }
    }
}