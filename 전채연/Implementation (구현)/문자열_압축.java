/*
    프로그래머스 > 2020 KAKAO BLIND RECRUITMENT : 문자열 압축
    - 문제 유형 : 구현
*/

class 문자열_압축 {
    public int solution(String s) {
        int min = s.length();
        int repeat = 0;
        

        // 브루트포스 실행 (i 단위로 잘라 압축)
        for (int i = 1; i <= s.length() / 2; i++) {
            int count = s.length();
            for (int j = i; j <= s.length() - i;j += i) {
                // 이전과 문자열이 반복된 경우
                if (s.substring(j - i, j).equals(s.substring(j, j + i))) repeat++;
                // 이전과 문자열이 반복되지 않는 경우
                else {
                    // 그 전에 반복된 문자열들이 존재하는 경우
                    if (repeat > 0) {
                        count -= repeat * i;
                        count += String.valueOf(repeat + 1).length();
                        repeat = 0;
                    }
                    System.out.println();
                }
            }
            // 반복된 문자열이 남아있는 경우
            if (repeat > 0) {
                count -= repeat * i;
                count += String.valueOf(repeat + 1).length();
                repeat = 0;
            }
            min = Math.min(min, count);
        }
        
        return min;
    }
}