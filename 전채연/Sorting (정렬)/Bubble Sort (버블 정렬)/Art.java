/*
    백준 19604번 : Art
    - 풀이 유형 : 버블 정렬 (Bubble Sort)
*/

import java.util.Scanner;

public class Art {
    // 버블 정렬 함수
    static void bubble_sort(int[] data, int size) {
        for (int j = size - 1; j > 0; j--) {
            for (int k = 0; k < j; k++) {
                if (data[k] > data[k + 1]) {
                    int temp = data[k];
                    data[k] = data[k + 1];
                    data[k + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int repeat = stdIn.nextInt(); // 페인트 방울의 개수
        int[] X = new int[repeat]; // 페인트 방울의 X 좌표 배열
        int[] Y = new int[repeat]; // 페인트 방울의 Y 좌표 배열

        // 입력
        for (int i = 0; i < repeat; i++) {
            // 문자열로 입력받고 ','를 기준으로 분할해야 함.
            String drop = stdIn.next();
            String[] drops = drop.split(",");
            X[i] = Integer.parseInt(drops[0]);
            Y[i] = Integer.parseInt(drops[1]);
        }

        // 버블 정렬 함수 호출
        bubble_sort(X, repeat);
        bubble_sort(Y, repeat);

        // 프레임 출력 : 왼쪽 하단 꼭짓점의 좌표와 오른쪽 상단 꼭짓점의 좌표
        System.out.printf("%d,%d\n", X[0] - 1, Y[0] - 1);
        System.out.printf("%d,%d\n", X[repeat - 1] + 1, Y[repeat - 1] + 1);

        stdIn.close();
    }
}