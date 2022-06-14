package chap06;

public class Example6_2 {
    public static void main(String[] args) {
        int[] array = {3, 5};

        int temp = array[0];
        array[0] = array[1];
        array[1] = temp;

        for (int i = 0; i < 2; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
