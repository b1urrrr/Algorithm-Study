import java.util.Scanner;

public class q3 {
    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int count = 0; // 몇개가 발견되었는지를 담는 변수
        for (int i = 0; i < n; i++) {
            if (key == a[i]) {
                idx[count] = i;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];
        int[] idx = new int[num]; // 일치하는 인덱스를 담는 배열

        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();
        int idx_num = searchIdx(x, num, ky, idx);

        if (idx_num == -1) System.out.println("그 값의 요소가 없습니다.");
        else System.out.println(ky + "은(는) 배열 a에 " + idx_num + "개 있습니다.");
        for (int i = 0; i < idx.length; i++)
            if (i == 0 || (i >= 1 && idx[i] != 0))
                System.out.println("그 값은 idx[" + idx[i] + "]에 있습니다.");
    }
}
