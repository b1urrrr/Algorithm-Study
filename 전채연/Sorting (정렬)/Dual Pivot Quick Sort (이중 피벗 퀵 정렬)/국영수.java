/*
    백준 10825번 : 국영수
    - 문제 유형 : 정렬
    - 풀이 유형 : Arrays.sort를 활용한 이중 피벗 퀵 정렬 (Dual Pivot Quick Sort)
*/

import java.io.*;
import java.util.*;

public class 국영수 {
    static class Student implements Comparable<Student> {
        String name;
        int korean;
        int english;
        int math;

        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }

        @Override
        public int compareTo(Student other) {
            // 국어 점수가 감소하는 순서
            if (this.korean < other.korean) return 1;
            else if (this.korean > other.korean) return -1;
            // 영어 점수가 증가하는 순서
            else if (this.english < other.english) return -1;
            else if (this.english > other.english) return 1;
            // 수학 점수가 감소하는 순서
            else if (this.math < other.math) return 1;
            else if (this.math > other.math) return -1;
            // 이름이 사전 순으로 증가하는 순서
            return this.name.compareTo(other.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도현이네 반의 학생 수 N 입력
        Student[] students = new Student[N];

        // 학생 정보 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken(); // 이름 입력
            int korean = Integer.parseInt(st.nextToken()); // 국어 점수 입력
            int english = Integer.parseInt(st.nextToken()); // 영어 점수 입력
            int math = Integer.parseInt(st.nextToken()); // 수학 점수 입력
            students[i] = new Student(name, korean, english, math);
        }

        // 정렬
        Arrays.sort(students);

        // 문제에 나와있는 정렬 기준으로 학생의 이름 출력
        for (int i = 0; i < N; i++) {
            System.out.println(students[i].name);
        }
    }
}
