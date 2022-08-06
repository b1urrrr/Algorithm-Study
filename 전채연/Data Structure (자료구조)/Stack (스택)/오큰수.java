import java.io.*;
import java.util.StringTokenizer;
import java.util.Stack;
import java.lang.StringBuilder;

public class 오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 수열의 크기 입력
        int[] arr = new int[N];
        Stack<Integer> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 수열의 원소 입력
            // 저장된 인덱스의 원소 값이 현재 값보다 크면 초기화
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                arr[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        // 스택의 남은 인덱스의 원소 값은 -1로 초기화
        while(!stack.isEmpty()) arr[stack.pop()] = -1;

        // NGE(1), NGE(2), ..., NGE(N) 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }
}
