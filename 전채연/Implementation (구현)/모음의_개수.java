import java.io.*;

public class 모음의_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String sentence = br.readLine(); // 영문장 입력
            if (sentence.equals("#")) return; // # 입력 시 종료

            int count = 0;
            for (int i = 0; i < sentence.length(); i++) {
                switch (sentence.charAt(i)) {
                    // 모음인 경우 개수 증가
                    case 'a':
                    case 'A':
                    case 'e':
                    case 'E':
                    case 'i':
                    case 'I':
                    case 'o':
                    case 'O':
                    case 'u':
                    case 'U':
                        count++;
                        break;
                    default:
                }
            }
            bw.write(count + "\n");
            bw.flush();
        }
    }
}