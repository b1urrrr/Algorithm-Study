/*
 * @author Minyeong Park
 * @date 2022.03.06.
 * 카드1
 * https://www.acmicpc.net/problem/2161
 */


import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i,i+1);
        }

        int temp; // 두번째 카드의 수를 임시저장하는 변수
        while (list.size() >= 2) {
//            bw.write(String.format("%d ", list.get(0)));      // 출력 1
            System.out.printf("%d ", list.get(0));              // 출력 2
            list.remove(0); // 맨 위의 카드를 버림

            if (list.size() >= 2) { // 맨 위 카드 제거하고 나서도 남은 카드가 2개 이상이면
                temp = list.get(0);
                list.remove(0); // 그 다음 맨 위의 카드를 버림
                list.addLast(temp);   // 임시저장했던 수를 맨 뒤에 추가
            }
        }
//        bw.write(list.get(0));              // 출력 1
        System.out.print(list.get(0));        // 출력 2
//        bw.flush();
    }
}