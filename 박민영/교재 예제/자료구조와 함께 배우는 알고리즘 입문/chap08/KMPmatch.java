public class KMPmatch {
    // KMP 법에 의한 문자열 검색
    static int kmpMatch(String txt, String pat) {
        int pt = 1; // txt 커서
        int pp = 0; // pat 커서
        int[] skip = new int[pat.length() + 1]; // 건너뛰기 표

        // 건너뛰기 표를 만듭니다.
        skip[pt] = 0;
        while (pt != pat.length()) {
            if (pat.charAt(pt) == pat.charAt(pp))
                skip[++pt] = ++pp;
            else if (pp == 0)
                skip[++pt] = pp;
            else
                pp = skip[pp];
        }

        // 검색
        pt = pp = 0;
        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0)
                pt++;
            else
                pp = skip[pp];
        }

        if (pp == pat.length()) // pt - pp를 반환합니다.
            return pt - pp;
        return -1; // 검색 실패
    }
}
