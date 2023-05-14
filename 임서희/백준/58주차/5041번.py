# 너비 우선 탐색
# 5041번: 스타트링크

import sys
from collections import deque

# bfs는 deque 함수와 while문 이용해서 문제 풀기
def bfs(v):
    q = deque([v])
    visited[v] = 1
    while q:
        v = q.popleft()
        if v == G:
            return count[G]
        for i in (v+U, v-D): #U만큼 위로 or D만큼 아래로
            if 0 < i <= F and not visited[i]:
                visited[i] = 1
                count[i] = count[v] + 1
                q.append(i)
    if count[G] == 0: # 초기화인 0 상태면 엘레베이터를 타고 도착하지 못한 것
        return "use the stairs"

input = sys.stdin.readline
F, S, G, U, D = map(int, input().split())
visited = [0 for i in range(F+1)]
count = [0 for i in range(F+1)] # 단순히 변수로 하기엔 갈라지는 부분이 존재해서 리스트로 만듦
print(bfs(S))

# 참고: https://letalearns.tistory.com/43
# bfs/dfs 언제쯤 풀이를 안보고 풀 수 있을까...