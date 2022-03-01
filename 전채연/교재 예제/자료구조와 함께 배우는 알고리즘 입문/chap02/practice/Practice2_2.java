package chap02.practice;

public class Practice2_2 {
    static void print_data(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.printf("%d ", data[i]);
        }
        System.out.println();
    }

    static void reverse(int[] data) {
        print_data(data);
        for (int i = 0; i < data.length / 2; i++) {
            System.out.printf("a[%d]과(와) a[%d]를 교환합니다.\n", i, data.length - i - 1);
            int temp = data[i];
            data[i] = data[data.length - i - 1];
            data[data.length - i - 1] = temp;
            print_data(data);
        }
    }

    public static void main(String[] args) {
        int[] data = {5, 10, 73, 2, -5, 42};

        reverse(data);
    }
}
