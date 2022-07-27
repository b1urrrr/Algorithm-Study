/*
 * @author Minyeong Park
 * @date 2022.07.27.
 * 수 찾기
 * 참고 : https://github.com/b1urrrr/Algorithm-Study/blob/main/%EB%B0%95%EB%AF%BC%EC%98%81/%EA%B5%90%EC%9E%AC%20%EC%98%88%EC%A0%9C/%EC%9D%B4%EA%B2%83%EC%9D%B4%20%EC%BD%94%EB%94%A9%20%ED%85%8C%EC%8A%A4%ED%8A%B8%EB%8B%A4/chap07/n7_2.java
 * 문제 링크 : https://www.acmicpc.net/problem/1920
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int search_num = Integer.parseInt(st.nextToken());
            if (binarySearch(search_num, 0, arr.length - 1))
                System.out.println(1);
            else
                System.out.println(0);
        }
    }

    static boolean binarySearch(int search_num, int start, int end) {
        if (start > end) {
            return false;
        }
        int pivot = (start + end) / 2;
        if (arr[pivot] == search_num) {
            return true;
        } else if (arr[pivot] < search_num) {
            return binarySearch(search_num, pivot + 1, end);
        } else {
            return binarySearch(search_num, start, pivot - 1);
        }
    }
}