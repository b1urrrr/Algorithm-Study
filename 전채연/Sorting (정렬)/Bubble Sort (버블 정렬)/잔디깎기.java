/*
    백준 3845번 : Art
    - 문제 유형 : 정렬, 스위핑 알고리즘
    - 풀이 유형 : 버블 정렬 (Bubble Sort)
*/

import java.util.Scanner;

public class 잔디깎기 {
    // 버블 정렬 함수
    static void bubble_sort(float[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    float temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    // 스위핑 알고리즘 함수
    static boolean sweep(float[] data, float width, float goal) {
        float start = data[0] - (width / 2);
        float end = data[0] + (width / 2);

        for (int i = 1; i < data.length; i++) {
            if (data[i] - (width / 2) <= end) { // 잔디를 깎은 범위를 하나로 합침
                end = data[i] + (width / 2);
            } else { // 잔디를 깎은 범위가 이어지지 않으면 break
                break;
            }
        }
        if (start <= 0 && end >= goal) return true;
        else return false;
    }
    
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        while (true) {
            int nx = stdIn.nextInt(); // 가로로 깎을 좌표의 개수
            int ny = stdIn.nextInt(); // 새로로 깎을 좌표의 개수
            float width = stdIn.nextFloat(); // 잔디 깎는 기계의 폭

            if (nx == 0 && ny == 0 && width == 0.0) break; // 0 0 0.0이 입력되면 종료

            boolean result = false;

            // 가로로 깎을 좌표들 입력
            float[] parallel = new float[nx];
            for (int i = 0; i < nx; i++) parallel[i] = stdIn.nextFloat();

            bubble_sort(parallel); // 버블 정렬 함수 호출
            result = sweep(parallel, width, 75.0f); // 스위핑 함수 호출

            // 세로로 깎을 좌표들 입력
            float[] vertical = new float[ny];
            for (int i = 0; i < ny; i++) vertical[i] = stdIn.nextFloat();

            bubble_sort(vertical); // 버블 정렬 함수 호출
            result = (result && sweep(vertical, width, 100.0f)); // 스위핑 함수 호출

            // 결과 출력
            System.out.println((result)? "YES" : "NO");
        }
    }
}
