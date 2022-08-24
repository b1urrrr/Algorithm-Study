import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][4];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            arr[i][3] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    if (o1[2] == o2[2]) {
                        return o2[3] - o1[3];
                    }
                    return o2[2] - o1[2];
                }
                return o2[1] - o1[1];
            }
        });

        int[][] find = new int[1][4];
        int result = 0;
        for (int i = 0; i <= n; i++) {
            if (arr[i][0] == k) {
                find[0][0] = arr[i][0];
                find[0][1] = arr[i][1];
                find[0][2] = arr[i][2];
                find[0][3] = arr[i][3];
                result = i;
            }
        }

        for (int i = result; i >= 0; i--) {
            if (arr[i][1] == find[0][1] && arr[i][2] == find[0][2] && arr[i][3] == find[0][3]) {
                result = i+1;
                continue;
            }
            else {
                break;
            }
        }
        System.out.println(result);
    }
}