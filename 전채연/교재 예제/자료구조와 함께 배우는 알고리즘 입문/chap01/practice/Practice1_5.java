package chap01.practice;

public class Practice1_5 {
    // Q5
    static int med3 (int a, int b, int c) {
        if ((b >= a && c <= a) || (b <= a && c >= a))
            return a;
        else if ((a > b && c < b) || (a < b && c > b))
            return b;
        return c;
    }

    public static void main(String[] main) {
        System.out.print(med3(1, 2, 3));
    }

    /*
    위와 같은 med3 메서드는 최대 14 번의 연산(비교 연산과 논리 연산)을 수행해야 결과가 반환된다.
    하지만 실습 1C-1의 med3 메서드는 a, b, c에 무슨 값이 전달되어도 최대 3 번의 비교 연산으로 결과를 반환할 수 있다.
    따라서 위에서 사용한 메서드는 실습 1C-1의 med3에 비해 효율이 떨어진다.
    */
}
