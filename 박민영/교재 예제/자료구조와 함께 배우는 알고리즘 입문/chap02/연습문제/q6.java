import java.util.Scanner;

public class q6 {
    static int cardConv(int x, int r, char[] d) { // x : 정숫값, r : 변환할 진수, d : 변환한 값의 각 자리 문자를 아랫자리부터 넣어둘 배열
        int digits = 0; //변환 후의 자릿수
        String dchar = "012345678ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        char[] tem_arr = new char[d.length]; //앞쪽부터 아랫자리를 넣어두는 배열 (임시 배열)

        do {
            tem_arr[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        for (int i = digits - 1, j = 0; i >= 0; i--,j++) { // 임시 배열을 거꾸로 탐색하면서 원래 배열에 값을 넣음
            d[j] = tem_arr[i];
        }
        return digits;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int no;    //변환하는 정수
        int cd;    //기수
        int dno;   //변환 후의 자릿수
        int retry; //다시 한번?
        char[] cno = new char[32]; //변환 후 각 자리의 숫자를 넣어두는 문자의 배열

        System.out.println("10진수를 기수 변환합니다.");
        do {
            do {
                System.out.print("변환하는 음이 아닌 정수 : ");
                no = stdIn.nextInt();
            } while(no < 0);

            do {
                System.out.print("어떤 진수로 변환할까요? (2~36) : ");
                cd = stdIn.nextInt();
            } while(cd < 2 || cd > 36);

            dno = cardConv(no, cd, cno); // no를 cd진수로 변환

            System.out.print(cd + "진수로는 ");
            for (int i = 0; i <= dno - 1; i++)
                System.out.print(cno[i]);
            System.out.println("입니다.");

            System.out.print("한 번 더 할까요? (1. 예 / 0. 아니오) : ");
            retry = stdIn.nextInt();
        } while(retry == 1);
    }
}
