public class QueenB {
    static int[] pos = new int[8]; // 각 열의 퀸의 위치

    static void print() {
        for (int i = 0; i < 8; i++)
            System.out.printf("%2d", pos[i]);
        System.out.println();
    }

    // i열에 퀸을 놓습니다.
    static void set(int i) {
        for (int j = 0; j < 8; j++) {
            pos[i] = j;     // 퀸을 j행에 배치
            if (i == 7)     // 모든 열에 배치
                print();
            else
                set(i + 1); // 다음 열에 퀸을 배치합니다.
        }
    }

    public static void main(String[] args) {
        set(0);             // 0열에 퀸을 배치합니다.
    }
}
