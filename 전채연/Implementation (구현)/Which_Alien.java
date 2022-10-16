import java.io.*;

public class Which_Alien {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int antenna = Integer.parseInt(br.readLine()); // 외계인의 안테나 개수
        int eye = Integer.parseInt(br.readLine()); // 외계인의 눈 개수

        // 가능한 외계인 유형 출력
        if (antenna >= 3 && eye <= 4) System.out.println("TroyMartian");
        if (antenna <= 6 && eye >= 2) System.out.println("VladSaturnian");
        if (antenna <= 2 && eye <= 3) System.out.println("GraemeMercurian");
    }
}