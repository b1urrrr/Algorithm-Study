import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class n13_20 {
    static int n;
    static int moveR[] = {-1, 1, 0, 0};
    static int moveC[] = {0, 0, -1, 1};
    static int answer;
    static ArrayList<ArrayList<Character>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Character>());
        }

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                char c = st.nextToken().charAt(0);
                graph.get(i).add(c);
            }
        }

        dfs(0, -1, 0);

        if (answer == 1)
            System.out.println("YES");
        else
            System.out.println("NO");
    }

    static void dfs(int x, int y, int count) {
        if (count == 3) {
            boolean yes = true; // 선생님을 피할 수 있는지

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph.get(i).get(j) != 'T') {
                        continue;
                    }

                    // 감시 가능한 학생이 존재하는지
                    boolean sw = findS(i, j);
                    // 감시가 가능하다면
                    if (sw == true) {
                        yes = false;
                        break;
                    }
                }
                if (yes == false)
                    break;
            }
            // 감시 불가능한 경우
            if (yes == true) {
                answer = 1;
            }
            return;
        }

        // 현재 x행에 대해 탐색
        for (int i = y + 1; i < n; i++) {
            // 빈 공간이 아니면 넘어가기
            if (graph.get(x).get(i) != 'X')
                continue;

            // 빈 공간들에 대해 진행
            graph.get(x).set(i, 'O');
            dfs(x, i, count + 1);
            graph.get(x).set(i, 'X');
        }

        // x+1행부터 마지막 행까지 하나씩 탐색
        for (int i = x + 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 빈 공간이 아니면 넘어가기
                if (graph.get(i).get(j) != 'X')
                    continue;

                // 빈 공간들에 대해 진행
                graph.get(i).set(j, 'O');
                dfs(i, j, count + 1);
                graph.get(i).set(j, 'X');
            }
        }
    }

    static boolean findS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextR = x;
            int nextC = y;

            while (true) {
                nextR += moveR[i];
                nextC += moveC[i];
                if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n)
                    break;
                if (graph.get(nextR).get(nextC) == 'O')
                    break;
                if (graph.get(nextR).get(nextC) == 'S') // 학생을 찾으면 true 반환
                    return true;
            }
        }
        return false;
    }
}