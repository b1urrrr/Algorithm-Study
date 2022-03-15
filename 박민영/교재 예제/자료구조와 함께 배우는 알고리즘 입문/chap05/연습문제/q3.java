import java.util.Scanner;
import java.util.StringTokenizer;

public class q3 {
    static int gcd_q3(int x, int y) {
        if (y == 0) return x;
        else return gcd_q3(y, x % y);
    }

    static int gcdArray(int[] a, int start, int no) { // start : 처음 인덱스, no : 요소 개수
        if (no == 1) return a[start];
        else if (no == 2) return gcd_q3(a[start],a[start+1]);
        else { // 3개 요소 이상
            return gcd_q3(a[start], gcdArray(a, start+1, no-1));
            // 처음 요소는 그대로 두고 다음 요소부터 배열 요소들을 하나씩 최대공약수를 파악한다.
            // no가 줄어들면서 재귀적 호출 --> 2번째 요소부터 배열 요소를 싹 다 gcd 작업을 거친 뒤에 마지막에 a[start]와도 gcd 작업을 통해
            // 배열 요소의 최종 최대 공약수를 구한다.
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("배열의 모든 요소의 최대공약수를 구합니다. ");
        System.out.print("정수 배열을 띄어쓰기로 구분하면서 입력하세요 : ");
        String str = stdIn.nextLine();
        StringTokenizer st = new StringTokenizer(str);
        int[] x = new int[st.countTokens()];
        for (int i = 0; i < st.countTokens(); i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println("최대공약수는 " + gcdArray(x, 0, x.length) + "입니다.");
    }
}
