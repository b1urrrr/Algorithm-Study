import java.io.*;

public class 밀비급일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String pwd = br.readLine(); // 암호 입력
            if (pwd.equals("END")) return; // END 입력 시 종료

            for (int i = pwd.length() - 1; i >= 0; i--) {
                bw.write(pwd.charAt(i)); // 역순으로 암호 출력
            }
            bw.newLine();
            bw.flush();
        }
    }
}