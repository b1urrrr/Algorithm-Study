class Solution {
    public long solution(int n, int k) {
        String change_number_str = Long.toString(n, k);

        String temp = "";
        long count = 0;
        for (int i = 0; i < change_number_str.length(); i++) {
            char c = change_number_str.charAt(i);
            if (c != '0') {
                temp += c;
                continue;
            }

            if (!temp.equals("") && isPrime(Long.parseLong(temp))) {
                count++;
            }
            temp = "";
        }

        if (!temp.equals("") && isPrime(Long.parseLong(temp))) {
            count++;
        }
        return count;
    }

    public boolean isPrime(long num) {
        if (num <= 1) return false;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) { // 소수가 아닌 경우
                return false;
            }
        }
        return true;
    }
}