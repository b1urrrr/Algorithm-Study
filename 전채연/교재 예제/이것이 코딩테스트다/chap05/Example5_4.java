package chap05;

public class Example5_4 {
    static void recursive_function(int i) {
        if (i == 100)
            return;
        System.out.printf("%d 번째 재귀 함수에서 %d 번째 재귀 함수를 호출합니다.\n", i, i + 1);
        recursive_function(i + 1);
        System.out.printf("%d 번째 재귀 함수를 종료합니다.\n", i);
    }

    public static void main(String[] args) {
        recursive_function(1);
    }
}
