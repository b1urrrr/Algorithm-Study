package chap07;

import java.io.*;
import java.util.StringTokenizer;

public class Example7_2 {
    static int binary_search(int target, int[] array, int start, int end) {
        if (start > end) return -1;
        int mid = (start + end) / 2;

        if (target < array[mid]) return binary_search(target, array, start, mid - 1);
        else if (target > array[mid]) return binary_search(target, array, mid + 1, end);
        else return mid;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] array = new int[size];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int result = binary_search(target, array, 0, size - 1);
        if (result == -1) System.out.println("원소가 존재하지 않습니다.");
        else System.out.println(result + 1);
    }
}
