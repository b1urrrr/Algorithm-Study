/*
 * @author Minyeong Park
 * @date 2022.03.20.
 * 재귀함수가 뭔가요?
 * https://www.acmicpc.net/problem/17478
 */


import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static void recur_print(int num, int count) throws IOException {
        int num_underbar = 0;
        if (count != 0) {
            num_underbar = count * 4;
        }
        for (int i = 0; i < num_underbar; i++) bw.write("_");
        bw.write("\"재귀함수가 뭔가요?\"\n");

        if (num == 0) {
            for (int i = 0; i < num_underbar; i++) bw.write("_");
            bw.write("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
            for (int i = 0; i < num_underbar; i++) bw.write("_");
            bw.write("라고 답변하였지.\n");
            return;
        }
        else {
            for (int i = 0; i < num_underbar; i++) bw.write("_");
            bw.write("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
            for (int i = 0; i < num_underbar; i++) bw.write("_");
            bw.write("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
            for (int i = 0; i < num_underbar; i++) bw.write("_");
            bw.write("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
        }

        recur_print(num - 1, count + 1);

        for (int i = 0; i < num_underbar; i++) bw.write("_");
        bw.write("라고 답변하였지.\n");
    }

    public static void main(String[] args) throws IOException{
        int num = Integer.parseInt(br.readLine());

        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        recur_print(num, 0);
        bw.flush();
    }
}