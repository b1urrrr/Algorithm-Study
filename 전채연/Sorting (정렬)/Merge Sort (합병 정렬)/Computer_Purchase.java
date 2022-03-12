/*
    백준 6799번 : Computer Purchase
    - 문제 유형 : 정렬, 문자열
    - 풀이 유형 : 합병 정렬 (Merge Sort)
*/

import java.util.Scanner;

public class Computer_Purchase {
    // 컴퓨터의 이름과 성능을 필드로 가지는 Computer 클래스
    static public class Computer {
        private String name;
        private int performance;
    
        // 생성자
        Computer(String name, int R, int S, int D) {
            this.name = name;
            this.setPerformance(R, S, D);
        }
    
        // getter
        public String getName() {
            return this.name;
        }
    
        public int getPerformance() {
            return this.performance;
        }
    
        // setter
        public void setPerformance(int R, int S, int D) {
            this.performance = (2 * R) + (3 * S) + D;
        }
    
        @Override
        public String toString() {
            return this.name;
        }
    }

    // 합병 시 정렬 완료된 요소들을 저장하는 배열
    static Computer[] sorted;

    // 합병 정렬을 위한 합병 함수
    static void merge(Computer[] data, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int k = start;

        while (i <= mid && j <= end) {
            if (data[i].getPerformance() < data[j].getPerformance()) sorted[k++] = data[i++];
            else if (data[i].getPerformance() > data[j].getPerformance()) sorted[k++] = data[j++];
            // 성능이 동일한 컴퓨터는 이름의 사전 순서를 기준으로 정렬
            else if (data[i].getName().compareTo(data[j].getName()) >= 0) sorted[k++] = data[i++];
            else sorted[k++] = data[j++];
        }

        if (mid < i) for (int t = j; t <= end; t++) sorted[k++] = data[t];
        else for (int t = i; t <= mid; t++) sorted[k++] = data[t];

        for (int t = start; t <= end; t++) data[t] = sorted[t];
    }

    // 합병 정렬 함수
    static void merge_sort(Computer[] data, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            merge_sort(data, start, mid);
            merge_sort(data, mid + 1, end);
            merge(data, start, mid, end);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int testCase = stdIn.nextInt(); // 테스트 케이스 개수 입력
        sorted = new Computer[testCase];
        Computer[] computers = new Computer[testCase]; // 컴퓨터 정보를 저장할 배열

        for (int i = 0; i < testCase; i++) {
            String name = stdIn.next(); // 컴퓨터 이름 입력
            int R = stdIn.nextInt(); // RAM 크기 입력
            int S = stdIn.nextInt(); // CPU 속도 입력
            int D = stdIn.nextInt(); // 디스크 드라이브 공간 입력
            computers[i] = new Computer(name, R, S, D); // 컴퓨터 객체 생성
        }

        if (testCase == 0) return; // 테스트 케이스 개수가 0개면 출력 없음
        else if (testCase == 1) System.out.println(computers[0]); // 테스트 케이스 개수가 1개면 한 번만 출력
        else {
            // 합병 정렬 함수 호출
            merge_sort(computers, 0, testCase - 1);
            System.out.println(computers[testCase - 1]); // 우선순위가 가장 높은 컴퓨터 이름 출력
            System.out.println(computers[testCase - 2]); // 두 번째로 우선순위가 높은 컴퓨터 이름 출력
        }
    }    
}
