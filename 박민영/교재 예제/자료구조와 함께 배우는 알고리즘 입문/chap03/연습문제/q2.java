import java.util.Scanner;

public class q2 {
    static int seqSearch(int[] a, int n, int key) {
        // 첫번째 줄 출력
        System.out.print("  | " );
        for (int i = 0; i < a.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // 두번째 줄 출력
        System.out.print("--+");
        for (int i = 0; i < a.length; i++) {
            System.out.print("--");
        }
        System.out.println();

        // 세번째 이후 줄 출력
        for (int i = 0; i < n; i++) {
            System.out.print("  | ");
            for (int j = 0; j < i; j++) {
                System.out.print("  ");
            }
            System.out.println("*");
            System.out.print(" " + i + "| ");
            for (int j = 0; j < n; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
            System.out.println("  |");
            if (a[i] == key) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();
        int idx = seqSearch(x, num, ky);  // 배열 x에서 키 값이 ky인 요소를 검색

        if (idx == -1) System.out.println("그 값의 요소가 없습니다.");
        else System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
    }
}
