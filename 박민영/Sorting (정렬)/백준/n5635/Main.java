/*
 * @author Minyeong Park
 * @date 2022.11.06.
 * 생일
 * 문제 링크 : https://www.acmicpc.net/problem/5635
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        student[] students = new student[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            students[i] = new student(name, day, month, year);
        }

        Arrays.sort(students);

        System.out.println(students[n-1]);
        System.out.println(students[0]);

    }
}

class student implements Comparable<student> {
    String name;
    int day;
    int month;
    int year;

    public student(String name, int day, int month, int year) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(student o) {
        if (this.year == o.getYear()) {
            if (this.month == o.getMonth()) {
                return Integer.compare(this.day, o.getDay());
            } else {
                return Integer.compare(this.month, o.getMonth());
            }
        }
        return Integer.compare(this.year, o.getYear());
    }

    @Override
    public String toString() {
        return name;
    }
}