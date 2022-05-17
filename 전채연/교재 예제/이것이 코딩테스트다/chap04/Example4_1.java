package chap04;

import java.io.*;
import java.util.StringTokenizer;

public class Example4_1 {
    static int[] move(int[] start, int[] dir, int size) {
        int[] temp = {start[0] + dir[0], start[1] + dir[1]};
        if (temp[0] < 1 || temp[0] > size || temp[1] < 1 || temp[1] > size) {
            return start;
        }
        return temp;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[][] direction = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // L R U D
        int[] start = {1, 1};

        while(st.hasMoreTokens()) {
            switch (st.nextToken()) {
                case "L":
                    start = move(start, direction[0], size);
                    break;
                case "R":
                    start = move(start, direction[1], size);
                    break;
                case "U":
                    start = move(start, direction[2], size);
                    break;
                case "D":
                    start = move(start, direction[3], size);
            }
        }

        System.out.println(start[0] + " " + start[1]);
    }
}
