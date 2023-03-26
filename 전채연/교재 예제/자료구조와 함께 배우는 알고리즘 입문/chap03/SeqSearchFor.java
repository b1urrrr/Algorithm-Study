package chap03;
import java.util.Scanner;

public class SeqSearchFor {
    static int seqSearch(int[] a, int n, int key) {
        for (int i = 0; i < n; i++)
            if(a[i] == key) return i;
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++) {
            System.out.printf("x[%d] : ", i);
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();
        int idx = seqSearch(x, num, ky);

        if (idx == -1) System.out.println("그 값의 요소가 없습니다.");
        else System.out.printf("%d은(는) x[%d]에 있습니다.\n", ky, idx);

        stdIn.close();
    }    
}
