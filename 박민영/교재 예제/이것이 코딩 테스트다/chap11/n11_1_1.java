// chap11 Q1. 모험가 길드 (내가 푼 것)
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n11_1_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] people = new int[n+1]; // 각 공포도 별로 몇 명인지 체크(각 인덱스가 공포도)
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int index = Integer.parseInt(st.nextToken());
            people[index] += 1;
        }

        int count = 0;

        count += people[1]; // 1명인 경우에는 혼자 그룹하면 되므로 그대로 더함
        people[1] = 0;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) { // 자기보다 작은 인덱스를 돌면서
                if (people[j] > 0 && people[i] > 0 && people[i] + people[j] >= i) { // (더 작은 공포도 사람 수) + (자신의 공포도 사람 수) 가 자신의 공포도보다 같거나 큰 경우
                    count++;
                    people[j]--;
                    people[i] -= i - j;
                }
            }
            while (people[i] >= i) { // 자신의 공포도와 일치하는 사람들만 가지고 그룹 만들기
                count++;
                people[i] -= i;
            }
        }
        System.out.println(count);
    }
}
