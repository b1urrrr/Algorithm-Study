# 피로도 (dfs/bfs)

answer = 0

def dfs(a, cnt, dungeons, visited):
    global answer 
    if cnt > answer:
        answer = cnt
    
    for i in range(len(dungeons)):
        if not visited[i] and a >= dungeons[i][0]:
            visited[i] = True
            dfs(a - dungeons[i][1], cnt + 1, dungeons, visited)
            visited[i] = False
        
def solution(k, dungeons):
    global answer
    visited = [False] * len(dungeons)
    dfs(a, 0, dungeons, visited)
    return answer