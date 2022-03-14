/*
 * @author Minyeong Park
 * @date 2022.03.06.
 * 스택
 * https://www.acmicpc.net/problem/10828
 */


import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        String[] input_array;

        for (int i = 0; i < n; i++) {
            input_array = br.readLine().split(" ");
            switch (input_array[0]) {
                case "push" :
                    stack.push(Integer.parseInt(input_array[1]));
                    break;
                case "pop" :
                    if (stack.empty()) bw.write(-1 + "\n");
                    else {
                        bw.write(stack.pop() + "\n");
                    }
                    break;
                case "size" :
                    bw.write(stack.size() + "\n");
                    break;
                case "empty" :
                    bw.write((stack.empty() ? 1 : 0) + "\n");
                    break;
                case "top" :
                    if (stack.empty()) bw.write(-1 + "\n");
                    else {
                        bw.write(stack.peek() + "\n");
                    }
                    break;
            }
        }
        bw.flush();
        bw.close();
    }
}