import java.io.*;

public class Winning_Score {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // Apples 팀의 점수 계산
        int Apples = Integer.parseInt(br.readLine()) * 3; // 3점슛 횟수 입력
        Apples += Integer.parseInt(br.readLine()) * 2; // 2점슛 횟수 입력
        Apples += Integer.parseInt(br.readLine()); // 1점슛 횟수 입력

        // Bananas 팀의 점수 계산
        int Bananas = Integer.parseInt(br.readLine()) * 3; // 3점슛 횟수 입력
        Bananas += Integer.parseInt(br.readLine()) * 2; // 2점슛 횟수 입력
        Bananas += Integer.parseInt(br.readLine()); // 1점슛 횟수 입력

        // 결과 출력
        if (Apples > Bananas) System.out.println("A");
        else if (Apples < Bananas) System.out.println("B");
        else System.out.println("T");
    }
}