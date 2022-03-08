package chap03.practice;

public class Practice3_4 {
    static int bin_search(int[] data, int key) {
        int start = 0;
        int end = data.length - 1;
        System.out.print("   |");
        for (int i = 0; i < data.length; i++) System.out.printf("%3d", i);
        System.out.print("\n---+");
        for (int i = 0; i < data.length; i++) System.out.print("---");
        System.out.println();

        do {
            int mid = (start + end) / 2;
                if (mid != key) {
                System.out.print("   |");
                for (int i = 0; i < data.length; i++) {
                    if (i == mid) System.out.print("  +");
                    else if (i == start) System.out.print(" <-");
                    else if (i == end) System.out.print(" ->");
                    else System.out.print("   ");
                }
                System.out.println();
                System.out.printf(" %d |", mid);
                for (int i = 0; i < data.length; i++) System.out.printf("  %d", data[i]);
                System.out.println();
            }   
            if (data[mid] == key) return mid;
            else if (data[mid] > key) end = mid - 1;
            else start = mid + 1;
            System.out.println("   |");
        } while (start <= end);
        return - 1;
    }
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 5, 6, 8, 9};
        int key = 2;

        int idx = bin_search(data, key);

        if (idx == -1) System.out.println("배열에 존재하지 않는 수입니다.");
        else System.out.printf("\n%d는 [%d]에 있습니다.\n", key, idx);
    }
}
