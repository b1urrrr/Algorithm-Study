public class BMmatch {
    // Boyer-Moore 법으로 문자열을 검색
    static int bmMatch(String txt, String pat) {
        int pt; // txt 커서
        int pp; // pat 커서
        int txtLen = txt.length(); // txt의 문자 개수
        int patLen = pat.length(); // pat의 문자 개수
        int[] skip = new int[Character.MAX_VALUE + 1]; // 건너뛰기 표

        // 건너뛰기 표 만들기
        for (pt = 0; pt <= Character.MAX_VALUE; pt++)
            skip[pt] = patLen;
        for (pt = 0; pt < patLen - 1; pt++)
            skip[pat.charAt(pt)] = patLen - pt - 1; // pt == patLen - 1

        // 검색
        while (pt < txtLen) {
            pp = patLen - 1; // pat의 끝 문자에 주목

            while (txt.charAt(pt) == pat.charAt(pp)) {
                if (pp == 0)
                    return pt; // 검색 성공
                pp--;
                pt--;
            }
            pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
        }
        return -1; // 검색 실패
    }
}
