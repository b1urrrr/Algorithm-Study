/*
    프로그래머스 > 깊이/너비 우선 탐색(DFS/BFS) : 네트워크
    - 문제 유형 : 그래프 탐색
    - 풀이 유형 : DFS (깊이 우선 탐색)
*/

public class 네트워크 {
    public boolean[] visited;
    
    // 깊이 우선 탐색 메서드
    public void dfs(int node, int n, int[][] computers) {
        // 방문 처리
        visited[node] = true;
        
        for (int i = 0; i < n; i++) {
            // 연결되지 않은 노드인 경우 무시
            if (computers[node][i] == 0) continue;
            // 이미 방문한 노드인 경우 무시
            if (visited[i]) continue;
            
            dfs(i, n, computers);
        }
    }
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
}
