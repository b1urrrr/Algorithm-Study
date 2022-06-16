// chap07 (3) 실전 문제 : 떡볶이 떡 만들기


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n7_8 {
//    // 0. 처음에 내가 푼 것 (틀림)
//    // 내가 푼 것은 순차 탐색을 이용하고 이진탐색을 이용하지 않아서 예시 케이스에는 맞지만 실제로는 시간 초과가 뜰 수 있는 틀린 코드다...
//    // 절단기의 높이가 1 ~ 10억까지 가능하므로 이렇게 큰 수를 보면 가장 먼저 이진 탐색을 떠올려야 한다!
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(br.readLine());
//        int[] ddeok = new int[n];
//        for (int i = 0; i < n; i++) {
//            ddeok[i] = Integer.parseInt(st.nextToken());
//        }
//
//        Arrays.sort(ddeok);
//        int h = ddeok[n-1];
//        int left_sum = 0;
//        while (true) {
//            for (int d : ddeok) {
//                if (h < d) {
//                    left_sum += d - h;
//                }
//            }
//            if (left_sum >= m)
//                break;
//            else {
//                left_sum = 0;
//                h--;
//            }
//        }
//        System.out.println(h);
//    }


//    // 1. 해설 원리 보고 수정한 코드 (재귀로 구현했음)
//    static int result = 0;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        st = new StringTokenizer(br.readLine());
//        int[] ddeok = new int[n];
//        for (int i = 0; i < n; i++) {
//            ddeok[i] = Integer.parseInt(st.nextToken());
//        }
//
//        Arrays.sort(ddeok);
//        binarySearch(ddeok, 0, ddeok[n-1], m);
//        System.out.println(result);
//    }
//
//    // 높이를 이진탐색으로 조절해가면서 찾아야 한다!
//    static int binarySearch(int[] ddeok, int start, int end, int target_height) {
//        if (start > end)
//            return -1;
//        int mid = (start + end) / 2;
//        int left_sum = 0;
//        for (int d : ddeok) {
//            if (mid < d) {
//                left_sum += d - mid;
//            }
//        }
//        if (left_sum < target_height)
//            return binarySearch(ddeok, start, mid - 1, target_height);
//        else {
//            result = mid;
//            return binarySearch(ddeok, mid + 1, end, target_height);
//        }
//    }


    // 하지만 현재 얻을 수 있는 떡볶이의 양에 따라서 자를 위치를 결정해야 하기 때문에 이를 재귀적으로 구현하는 것은 귀찮은 작업이라고 한다.
    // 따라서 이와 같은 파라메트릭 서치 문제 유형은 이진 탐색을 반복문을 이용해 구현하면 더 간결하게 풀 수 있다고 한다.
    // 2. 반복문으로 구현한 코드
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ddeok = new int[n];
        for (int i = 0; i < n; i++) {
            ddeok[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ddeok);
        int start = 0;
        int end = ddeok[n-1];
        int mid = 0;
        int result = 0;
        while (start <= end) {  // 작거나 같은 경우임!
            mid = (start + end) / 2;
            int left_sum = 0;
            for (int d : ddeok) {
                if (mid < d) {
                    left_sum += d - mid;
                }
            }
            if (left_sum < m) { // 떡의 양이 부족한 경우 더 많이 자르기 (왼쪽 부분 탐색)
                end = mid - 1;
            } else {            // 떡의 양이 충분한 경우 덜 자르기 (오른쪽 부분 탐색)
                result = mid;   // 최대한 덜 잘랐을 때가 정답이므로, 여기에서 result에 기록
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
