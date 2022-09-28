package chap13;

class Solution {
    // 올바른 괄호 문자열 여부 반환 메서드
    public boolean correct(String p) {
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            switch(p.charAt(i)) {
                case '(':
                    count++;
                    break;
                case ')':
                    if (count == 0) return false;
                    count--;
                    break;
            }
        }
        
        if (count > 0) return false;
        return true;
    }
    
    public String solution(String p) {
        // 올바른 괄호 문자열이면 그대로 반환
        if (correct(p)) return p;
        
        int count = 0;
        String u = p.substring(0, 1);
        if (u.equals("(")) count++;
        else count--;
        String v;
        int i = 1;
        for (; i < p.length(); i++) {
            u += p.substring(i, i + 1);
            switch(p.charAt(i)) {
                case '(':
                    count++;
                    break;
                case ')':
                    count--;
                    break;
            }
            // u가 균형잡힌 괄호 문자열로 분리된 상태인 경우
            if (count == 0) {
                break;
            }
        }
        // u가 올바른 괄호 문자열인 경우
        if (correct(u)) {
            v = solution(p.substring(i + 1, p.length()));
            return u + v;
        // u가 올바른 괄호 문자열이 아닌 경우
        } else {
            v = "(" + solution(p.substring(i + 1, p.length())) + ")";
            u = u.substring(1, u.length() - 1);
            for (int t = 0; t < u.length(); t++) {
                switch(u.charAt(t)) {
                    case '(':
                        v += ")";
                        break;
                    case ')':
                        v += "(";
                        break;
                }
            }
            return v;
        }
    }
}
