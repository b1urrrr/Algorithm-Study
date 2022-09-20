// 진행 중
class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        int index = 0;
        for (int length = 1; length < s.length() / 2; length++) {
            int temp_count = 0;
            while (index <= 5) {
                String a_str = s.substring(index, index+length);
                String b_str = s.substring(index+length, index+length*2);
                System.out.println(a_str + " : " + b_str);
                
                if (a_str.equals(b_str)) {
                    temp_count += length + 1;
                    index += length * 2;
                } else {
                    index += length;
                    temp_count += length;
                }
            }
            
            if (temp_count < answer) {
                answer = temp_count;
            }
        }
        
        return answer;
    }
}
