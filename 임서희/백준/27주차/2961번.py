# 브루트포스 알고리즘, 비트마스킹
# 2961번: 도영이가 만든 맛있는 음식

# 내 코드: 틀림
# 테스트 코드만 맞음
N = int(input()) # 재료의 개수
n_list = list()
for i in range(N):
    s, b = map(int, input().split()) # 신맛, 쓴맛
    n_list.append([s,b])
s_list = []
b_list = []
for i in range(N):
    s_list.append(n_list[i][0])
    b_list.append(n_list[i][1])
    s_add = n_list[i][0]
    b_add = n_list[i][1]
    for j in range(i+1, N):
        s_add *= n_list[j][0]
        b_add += n_list[j][1]
        s_list.append(s_add)
        b_list.append(b_add)
min = 1000000000
for i in range(len(s_list)):
    if abs(s_list[i]-b_list[i]) < min:
        min = abs(s_list[i]-b_list[i])
print(min)

# 다른 사람 코드
# 내 코드가 틀렸던 이유: 모든 경우의 수를 다 보질 않았음 → 1개 뽑는 경우, 2개 뽑는 경우,... 를 다 봐야 하는데
# 실수로 모든 경우가 아니라 일부만 확인함

import sys, itertools
from itertools import combinations
input = sys.stdin.readline

n = int(input())
sour = []
bitter = []
for _ in range(n):
    a, b = map(int, input().split())
    sour.append(a)
    bitter.append(b)

diff = float('inf')

for i in range(1, n+1): # 재료를 i개 뽑을 때
    idxs = list(combinations(list(range(n)), i)) # 가능한 경우를 담은 리스트

    for food in idxs: # 경우 하나씩 탐색
        s = 1
        b = 0

        for j in range(i): # 맛 계산
            s *= sour[food[j]]
            b += bitter[food[j]]
        if abs(s - b) < diff:
            diff = abs(s - b)

print(diff)
