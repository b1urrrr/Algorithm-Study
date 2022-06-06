package chap05;

public class Example5_6 {
    static final int INF = Integer.MAX_VALUE;
    static int[][] graph = {
        {0, 7, 5},
        {7, 0, INF},
        {5, INF, 0}
    };

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.print("{");
            for (int j = 0; j < 3; j++) {
                System.out.printf(" %d ", graph[i][j]);
            }
            System.out.println("}");
        }
    }
}
