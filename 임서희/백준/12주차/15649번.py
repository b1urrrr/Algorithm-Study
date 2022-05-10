# 백트래킹 알고리즘
# N과 M(1)

# 백트래킹
# 백트래킹: Depth-First-Search 깊이 우선 탐색을 기반으로 스택을 이용하여
# '불필요한 경우를 배제'하면서 원하는 해답에 도달할 때까지 탐색하는 전략

# 브루트포스
#brute: 무식한, force: 힘   무식한 힘으로 해석할 수 있다.
#완전탐색 알고리즘. 즉, 가능한 모든 경우의 수를 모두 탐색하면서 요구조건에 충족되는 결과만을 가져온다.

# 백트래킹 vs 브루트포스
# 백트래킹은 브루트포스 전략처럼 모든 경우의 수를 탐색하되, 처리 속도를 위한 '가지치기가 필요'하다.
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