# 백트래킹: Depth-First-Search 깊이 우선 탐색을 기반으로 스택을 이용하여
# 불필요한 경우를 배제하면서 원하는 해답에 도달할 때까지 탐색하는 전략
# 브루트포스 전략처럼 모든 경우의 수를 탐색하되, 처리 속도를 위한 가지치기가 필요
# 스택을 이용하여 해당 경우의 수를 우선 push 했다가 동작 f()을 마치면 pop을 한다.

N, M = map(int, input().split())

s = []

def dfs():
    if len(s) == M:
        print(' '.join(map(str,s)))
        return
    for i in range(1, n+1):
        if i not in s:
            s.append(i)
            dfs()
            s.pop()

dfs()