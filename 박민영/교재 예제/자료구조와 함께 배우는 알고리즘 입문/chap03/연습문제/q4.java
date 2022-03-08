import java.util.Scanner;

public class q4 {
    static int binSearch(int[] a, int n, int key) {
        int pl = 0;     // 검색 범위의 첫 인덱스
        int pr = n - 1; // 검색 범위의 끝 인덱스

        // 첫번째 줄 출력
        System.out.print("  | " );
        for (int i = 0; i < a.length; i++) {
            System.out.print(i + "  ");
        }
        System.out.println();

        // 두번째 줄 출력
        System.out.print("--+");
        for (int i = 0; i < a.length; i++) {
            System.out.print("----");
        }
        System.out.println();

        do {
            int pc = (pl + pr) / 2 % 2 == 0 ?
                    (pl + pr) / 2 - 1 : (pl + pr) / 2;  // 중앙 요소의 인덱스

            // 화살표 라인
            System.out.print("  | ");
            for (int j = 0; j < pl; j++) {
                System.out.print("  ");
            }
            System.out.print("<- ");

            for (int j = 0; j < pc - pl - 1; j++) {
                System.out.print("   ");
            }
            System.out.print("+  ");

            for (int j = 0; j < pr - pc - 1; j++) {
                System.out.print("   ");
            }
            System.out.print("->\n");

            // 배열 요소 라인
            System.out.print(" " + pc + "| ");
            for (int j = 0; j < n; j++) {
                System.out.print(a[j] + "  ");
            }
            System.out.println();
            System.out.println("  |");
            if (a[pc] == key) return pc;
            else if (a[pc] < key)
                pl = pc + 1;  // 검색 범위를 뒤쪽 절반으로 좁힘
            else
                pr = pc - 1;  // 검색 범위를 앞쪽 절반으로 좁힘
        } while (pl <= pr);

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
        int idx = binSearch(x, num, ky);  // 배열 x에서 키 값이 ky인 요소를 검색

        if (idx == -1) System.out.println("그 값의 요소가 없습니다.");
        else System.out.println(ky + "은(는) x[" + idx + "]에 있습니다.");
    }
}
