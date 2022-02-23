package chap01.practice;

public class Practice1_12 {
    public static void main(String[] args) {
        System.out.print("   |");
        for (int i = 1; i < 10; i++) System.out.printf("%3d", i);
        System.out.println("\n---+--------------------------");

        for (int col = 1; col < 10; col++) {
            System.out.printf(" %d |", col);
            for (int row = 1; row < 10; row++) {
                System.out.printf("%3d", col * row);
            }
            System.out.println();
        }
    }
}
