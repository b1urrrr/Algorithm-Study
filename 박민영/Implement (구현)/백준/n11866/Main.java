/*
 * @author Minyeong Park
 * @date 2022.07.28.
 * 요세푸스 문제 0
 * 문제 링크 : https://www.acmicpc.net/problem/11866
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        System.out.print("<");
        int index = k - 1;
        while (list.size() != 0) {
            int remove_num = list.remove(index);
            if (list.size() == 0) {
                System.out.print(remove_num + ">");
                break;
            } else {
                System.out.print(remove_num + ", ");
            }

            index += k - 1;
            while (index >= list.size()) {
                index -= list.size();
            }
//             // 더 간단하게 푸는 방법 : 현재 큐의 크기를 나눈 나머지 값으로 진행한다
//            index = (index + (k - 1)) % list.size();
        }
    }
}