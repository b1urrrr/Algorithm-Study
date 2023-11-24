/*
 * @author Minyeong Park
 * @date 2023.10.22.
 * 한 줄로 서기
 * 문제 링크 : https://www.acmicpc.net/problem/1138
 * 원리 참고 : https://dundung.tistory.com/76
 */



import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = n; i > 0; i--) {
            list.add(arr[i], i);
        }

        for (int e : list) {
            System.out.print(e + " ");
        }
    }
}