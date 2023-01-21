/*
 * @author Minyeong Park
 * @date 2023.01.22.
 * 팀 이름 정하기
 * 문제 링크 : https://www.acmicpc.net/problem/1296
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String y_name = br.readLine();
        int n = Integer.parseInt(br.readLine());

        int max_prob = 0;
        HashMap<String, Integer> prob_map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String team_name = br.readLine();
            HashMap<Character, Integer> cal_map = new HashMap<>();
            cal_map.put('L', 0);
            cal_map.put('O', 0);
            cal_map.put('V', 0);
            cal_map.put('E', 0);

            for (int j = 0; j < y_name.length(); j++) {
                if (cal_map.containsKey(y_name.charAt(j))) {
                    cal_map.put(y_name.charAt(j), cal_map.get(y_name.charAt(j)) + 1);
                }
            }
            for (int j = 0; j < team_name.length(); j++) {
                if (cal_map.containsKey(team_name.charAt(j))) {
                    cal_map.put(team_name.charAt(j), cal_map.get(team_name.charAt(j)) + 1);
                }
            }

            int temp_prob = ((cal_map.get('L')+cal_map.get('O')) * (cal_map.get('L')+cal_map.get('V')) * (cal_map.get('L')+cal_map.get('E')) * (cal_map.get('O')+cal_map.get('V')) * (cal_map.get('O')+cal_map.get('E')) * (cal_map.get('V')+cal_map.get('E'))) % 100;

            prob_map.put(team_name, temp_prob);

            if (temp_prob >= max_prob) {
                max_prob = temp_prob;
            }
        }

        PriorityQueue<String> q = new PriorityQueue<>();
        for (String team : prob_map.keySet()) {
            if (prob_map.get(team) == max_prob) {
                q.add(team);
            }
        }

        System.out.println(q.poll());
    }
}