package chap02.practice;

public class Practice2_3 {
    static int sumOf(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5};
        System.out.printf("모든 요소의 합계 : %d" ,sumOf(data));
    }   
}
