package chap06;

public class Example6_6 {
    static final int MAX = 9;
    static final int SIZE = 15;

    public static void main(String[] args) {
        int[] array = {7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2};
        int[] count = new int[MAX + 1];

        for (int i = 0; i < SIZE; i++) {
            count[array[i]]++;
        }

        for (int i = 0; i <= MAX; i++) {
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i + " ");
            }
        }
    }
}
