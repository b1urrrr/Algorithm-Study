/*
 * @author Minyeong Park
 * @date 2022.03.02.
 * 줄 세우기
 * https://www.acmicpc.net/problem/2605
 */


import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int student_count = Integer.parseInt(br.readLine()); // 학생 수
        int student = 1; // 처음 시작 하는 학생 번호는 1
        int wanted = 0;  // 다음 번호 학생이 뽑은 번호

        StringTokenizer st = new StringTokenizer(br.readLine());

        LinkedList<Integer> list = new LinkedList<Integer>();
        while (st.hasMoreTokens()) {
            wanted = Integer.parseInt(st.nextToken());
            list.add(wanted,student);
            student++;
        }

        for (int i = student_count - 1; i >= 0 ; i--) {
            bw.write(String.format("%d ", list.get(i)));
        }

        bw.flush();
    }
}
