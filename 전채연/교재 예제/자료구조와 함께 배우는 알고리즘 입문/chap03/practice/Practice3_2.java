package chap03.practice;

public class Practice3_2 {
    static int seqSearch(int[] data, int key) {
        System.out.print("   |");
        for (int i = 0; i < data.length; i++) System.out.printf("%3d", i);
        System.out.print("\n---+");
        for (int i = 0; i < data.length; i++) System.out.print("-----");
        System.out.println();

        int count = 0;
        int i = 0;
        for ( ; i < data.length; i++, count++) {
            System.out.print("   |  ");
            for (int j = 0; j < i; j++) System.out.print("   ");
            System.out.println("*");

            System.out.printf("%2d |  ", count);
            for (int j = 0; j < data.length; j++) System.out.printf("%-3d", data[j]);
            System.out.println();

            if(data[i] == key) break;
            System.out.println("   |");
        }
        return i;
    }

    public static void main(String[] args) {
        int[] data = {6, 4, 3, 2, 1, 9, 8};
        int key = 3;

        int idx = seqSearch(data, key);

        if (idx == data.length) System.out.println("해당하는 값의 요소가 없습니다.");
        else System.out.printf("%d은 x[%d]에 있습니다.", key, idx);
    }
}
