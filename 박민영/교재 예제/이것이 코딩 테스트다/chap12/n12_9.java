// chap12 Q9. 문자열 압축

class Solution {
    public int solution(String s) {
        int answer = s.length();

        int index = 0;
        for (int length = 1; length < s.length() / 2 + 1; length++) {
            String compressed = "";
            String prev = s.substring(index, index+length);
            int cnt = 1;

            // 단위 크기(length) 만큼 증가시키며 이전 문자열과 비교
            for (int j = length; j < s.length(); j += length) {
                // 이전 상태와 동일하다면 압축 횟수(cnt) 증가
                String sub = "";
                for (int k = j; k < j + length; k++) {
                    if (k < s.length()) sub += s.charAt(k);
                }

                if (prev.equals(sub)) cnt += 1;
                    // 다른 문자열이 나왔다면 (더이상 압축하지 못하는 경우라면)
                else {
                    compressed += (cnt >= 2) ? cnt + prev : prev;
                    sub = "";
                    // length만큼 추출
                    for (int k = j; k < j + length; k++) {
                        if (k < s.length()) sub += s.charAt(k);
                    }
                    prev = sub; // 다시 상태 초기화
                    cnt = 1;
                }
            }

            // 남아 있는 문자열에 대해서 처리
            compressed += (cnt >= 2) ? cnt + prev : prev;

            // 만들어지는 압축 문자열이 가장 짧은 것이 정답
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }
}