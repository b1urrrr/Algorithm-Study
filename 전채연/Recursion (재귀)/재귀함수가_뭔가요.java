/*
    백준 17478번 : 재귀함수가 뭔가요?
    - 문제 유형 : 재귀
*/

import java.io.*;

public class 재귀함수가_뭔가요 {
    static int d;

    static void recursive(int depth) {
        String line = "";

        if (depth <= 0) {
            for (int i = 0; i < d; i++) {
                line += "____";
            }
        } else {
            for (int i = 0; i < d - depth; i++) {
                line += "____";
            }
        }

        // 머리 출력
        System.out.println(line + "\"재귀함수가 뭔가요?\"");

        if (depth <= 0) {
            System.out.println(line + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(line + "라고 답변하였지.");
            return ;
        }

        System.out.println(line + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(line + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(line + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        recursive(depth - 1);
        // 꼬리 출력
        System.out.println(line + "라고 답변하였지.");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        d = Integer.parseInt(br.readLine());
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursive(d);
    }    
}
