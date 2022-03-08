package chap03;

public class A implements Comparable <A> {
    // Comparable<A> 인터페이스 구현 (필드, 메서드)

    public int compareTo(A c) {
        // compareTo 메서드 구현
        // (this > c) 양의 값 반환
        // (this < c) 음의 값 반환
        // (this == c) 0 반환
        return 0; // 임의로 반환시킨 상태
    }

    public boolean equals(Object c) {
        // equals 메서드 구현
        // (this == c) true 반환
        // (this != c) flase 반환
        return false; // 임의로 반환시킨 상태
    }
    
}
