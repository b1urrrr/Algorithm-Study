/*
 * @author Minyeong Park
 * @date 2023.02.03.
 * 수들의 합 2
 * 그냥 일일이 파악하자니 시간초과 뜨기 딱 좋고, 다른 방법은 감이 안 왔다..
 * 원리 및 코드 참고 : https://code0xff.tistory.com/128?category=723754
 * 문제 링크 : https://www.acmicpc.net/problem/2003
 */


/*
 * 투포인터 : "연속되는 value"들을 이용하여 특정 목표에 맞는 값을 찾아주는 알고리즘
 *           - O(N^2) 이상으로 해결해야하는 문제를 선형시간(O(N))으로 해결
 *
 * 투포인터 사용 안 하고 백트래킹 등 완전 탐색을 진행하면 시간초과가 발생할 것임.
 *
 * 원리 :
 * 1. 배열을 가리키는 2개의 포인터 만들기 -> 각각 배열에서 특정 위치를 지정해주는 시작점과 끝점
 * 2. 두 개의 포인터를 정수들을 더해주는 과정에서 움직이게 됨.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start_ptr = 0;
        int end_ptr = 0;
        int temp_sum = 0;
        int result = 0;
        while (true) {
            if (temp_sum >= m) {
                temp_sum -= arr[start_ptr++];
            } else if (end_ptr > n - 1) {
                break;
            } else {
                temp_sum += arr[end_ptr++];
            }

            if (temp_sum == m) {
                result++;
            }
        }

        System.out.println(result);
    }
}