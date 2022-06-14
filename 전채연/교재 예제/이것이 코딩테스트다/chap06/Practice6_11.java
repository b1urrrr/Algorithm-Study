package chap06;

import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 성적이 낮은 순서로 학생 출력하기
public class Practice6_11 {
    static class Student implements Comparable<Student> {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        // 성적이 낮은 순서대로 비교하는 compareTo 메서드 구현
        @Override
        public int compareTo(Student other) {
            if (this.score > other.score) return 1;
            return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 학생의 수 N 입력
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken(); // 이름 입력
            int score = Integer.parseInt(st.nextToken()); // 점수 입력

            students.add(new Student(name, score));
        }

        // compareTo를 기반으로 정렬
        Collections.sort(students);

        // 성적이 낮은 순서대로 학생의 이름 출력
        for (int i = 0; i < N; i++) {
            System.out.print(students.get(i).name + " ");
        }
    }
}
