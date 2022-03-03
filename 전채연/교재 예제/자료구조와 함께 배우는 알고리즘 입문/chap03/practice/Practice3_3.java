package chap03.practice;

public class Practice3_3 {
    static int searchIndx(int[] a, int n, int key, int[] idx) {
        int count = 0;
        for (int i = 0; i < a.length; i++) if (a[i] == key) idx[count++] = i;
        return count;
    }
    public static void main(String[] args) {
        int[] data = {1, 9, 2, 9, 4, 6, 7, 9};
        int[] idx = new int[data.length];
        int count = searchIndx(data, data.length, 9, idx);
        System.out.println("탐색 개수 : " + count);

        int value = -1;
        for (int index : idx) {
            if (value >= index) break;
            value = index;
            System.out.printf("idx[%d] = %d\n", index, value);
        }
    }
}
