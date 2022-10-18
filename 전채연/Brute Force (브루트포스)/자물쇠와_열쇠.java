/*
    프로그래머스 > 2020 KAKAO BLIND RECRUITMENT : 자물쇠와 열쇠
    - 문제 유형 : 구현, 브루트 포스
*/

public class 자물쇠와_열쇠 {
    // 열쇠 시계방향 90도 회전 메서드
    public int[][] spin(int[][] key, int M) {
        int[][] result = new int[M][M];
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                result[j][M - i - 1] = key[i][j];
            }
        }
        return result;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;
        
        // 자물쇠 크기 확장 
        int[][] locker = new int[N + M + M][N + M + M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                locker[i + M][j + M] = lock[i][j];
            }
        }
        
        // 열쇠를 회전한 4가지 경우 모두 고려
        for (int s = 0; s < 4; s++) {
            // 완전 탐색 수행 (열쇠를 (i, j)만큼 이동)
            for (int i = 0; i < N + M; i++) {
                MOVE : for (int j = 0; j < N + M; j++) {
                    // 자물쇠의 (x, y)와 열쇠 비교
                    for (int x = 0; x < N + M + M; x++) {
                        for (int y = 0; y < N + M + M; y++) {
                            // 자물쇠의 범위가 아닌 경우
                            if (x < M || x >= M + N || y < M || y >= M + N) { }
                            // 자물쇠의 범위인 경우
                            // 열쇠의 범위가 아닌 경우
                            else if (x < i || i + M <= x || y < j || j + M <= y) {
                                if (locker[x][y] == 0) {
                                    continue MOVE;
                                }
                            }
                            // 열쇠가 홈인 경우
                            else if (key[x - i][y - j] == 0) {
                                if (locker[x][y] == 0) {
                                    continue MOVE;
                                }
                            }
                            // 열쇠가 돌기인 경우
                            else {
                                if (locker[x][y] == 1) {
                                    continue MOVE;
                                }
                            }
                        }
                    }
                    return true;
                }
            }
            // 열쇠를 시계방향으로 90도 회전
            key = spin(key, M);
        }
        return false;
    }
}