package chap02;

public class IntArrayInit {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};

        for (int i = 0; i < a.length; i++)
            System.out.printf("a[%d] = %d\n", i, a[i]);
    }
}
