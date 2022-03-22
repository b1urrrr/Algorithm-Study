package chap05.practice;

public class Practice5_9 {
    static boolean[] flag_a = new boolean[8];
    static boolean[] flag_b = new boolean[15];
    static boolean[] flag_c = new boolean[15];
    static int[] pos = new int[8];

    static void print() {
        for (int i = 0; i < 8; i++)
            System.out.printf("%2d", pos[i]);
        System.out.println();
    }

    static void set(int i) {
        int j;
        int[] stk = new int[8];

        Start: while(true) {
            j = 0;
            while (true) {
                // 모든 행을 탐색하면서 가능한 경우에 퀸 배치
                while(j < 8) {
                    if (flag_a[j] == false &&       // 배치 여부
                    flag_b[i + j] == false &&       // 대각선 / 배치 여부
                    flag_c[i - j + 7] == false) {   // 대각선 \ 배치 여부
                        pos[i] = j;
                        if (i == 7)
                            print();
                        else {
                            flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                            stk[i++] = j; // i열의 행 스택에 저장
                            continue Start;
                        }
                    }
                    j++;
                }

                // 다음 단계의 행을 처리하기 위해 변수 설정
                if (--i == -1) return; // 스택이 빈 경우 즉, 모든 경우를 탐색한 경우 종료
                j = stk[i]; // 스택에서 i열의 행을 꺼냄
                flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
                j++; // 스택에서 꺼낸 행의 다음 행부터 처리
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
