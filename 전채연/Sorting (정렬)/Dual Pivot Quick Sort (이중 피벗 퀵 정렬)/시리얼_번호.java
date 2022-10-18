import java.io.*;
import java.util.*;

public class 시리얼_번호 {
    static class Serial implements Comparable<Serial> {
        String serialNum;
        int sum;

        public Serial(String serialNum) {
            this.serialNum = serialNum;
            this.sum = 0;
            for (int i = 0; i < serialNum.length(); i++) {
                if (serialNum.charAt(i) < '9') this.sum += serialNum.charAt(i) - '0';
            }
        }

        @Override
        public int compareTo(Serial other) {
            if(this.serialNum.length() != other.serialNum.length()) return Integer.compare(this.serialNum.length(), other.serialNum.length());
            else if (this.sum != other.sum) return Integer.compare(this.sum, other.sum);
            else return this.compareTo(other);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Serial[] serials = new Serial[N];

        for (int i = 0; i < N; i++) {
            serials[0] = new Serial(br.readLine());
        }

        Arrays.sort(serials);

        for (int i = 0; i < N; i++) {
            System.out.println(serials[i].serialNum);
        }
    }
}
