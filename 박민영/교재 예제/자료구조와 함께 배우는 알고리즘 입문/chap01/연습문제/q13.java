public class q13 {
    public static void main(String[] args) {
        System.out.print("   | ");
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%3d", i);
        }
        System.out.print("\n---+----------------------------\n");
        for (int i = 1; i <= 9; i++) {
            System.out.printf("  %d| ", i);
            for (int j = 1; j <= 9; j++)
                System.out.printf("%3d", i + j);
            System.out.println();
        }
    }
}
