import java.io.*;
import java.util.Arrays;

public class 과목선택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] science = new int[4];
        int[] social = new int[2];
        for (int i = 0; i < 4; i++) {
            science[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 2; i++) {
            social[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(science);
        Arrays.sort(social);

        int sum = science[1] + science[2] + science[3] + social[1]; 
        System.out.println(sum);
    }
}