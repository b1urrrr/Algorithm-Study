package chap07;

import java.io.*;
import java.util.StringTokenizer;

public class Example7_1 {
    // 탐색 데이터의 위치를 반환하는 순차 탐색 메서드
    static int sequential_search(int size, String target, String[] array) {
        for (int i = 0; i < size; i++) {
            if (target.equals(array[i])) return i + 1;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("생성할 원소 개수를 입력한 다음 한 칸 띄고 찾을 문자열을 입력하세요.");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        String target = st.nextToken();
        String[] array = new String[size];

        System.out.println("앞서 적은 원소 개수만큼 문자열을 입력하세요. 구분은 띄어쓰기 한 칸으로 합니다.");
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < size; i++) {
            array[i] = st.nextToken();
        }

        System.out.println(sequential_search(size, target, array));
    }
}