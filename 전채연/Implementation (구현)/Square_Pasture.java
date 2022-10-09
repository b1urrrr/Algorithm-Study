import java.io.*;
import java.util.*;

public class Square_Pasture {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int minX = Integer.parseInt(st.nextToken());
        int minY = Integer.parseInt(st.nextToken());
        int maxX = Integer.parseInt(st.nextToken());
        int maxY = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        minX = Math.min(minX, Integer.parseInt(st.nextToken()));
        minY = Math.min(minY, Integer.parseInt(st.nextToken()));
        maxX = Math.max(maxX, Integer.parseInt(st.nextToken()));
        maxY = Math.max(maxY, Integer.parseInt(st.nextToken()));

        int x = Math.abs(maxX - minX);
        int y = Math.abs(maxY - minY);
        int len = Math.max(x, y);

        System.out.println(len * len);
    }
}
