/*
 * @author Minyeong Park
 * @date 2022.11.20.
 * (재귀함수) 피보나치 수열
 * 문제 링크 : https://codeup.kr/problem.php?id=1915&rid=0
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] arr = new int[21];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n == 1 || n == 2) {
            System.out.println(1);
            return;
        }
        recur(1);
        System.out.println(arr[n]);
    }

    static void recur(int count) {
        if (count == 1 || count == 2) {
            arr[count] = 1;
            recur(count+1);
            return;
        }

        if (count == n) {
            arr[count] = arr[count-1] + arr[count - 2];
            return;
        }


        arr[count] = arr[count - 1] + arr[count - 2];
        recur(count + 1);
        return;
    }
}