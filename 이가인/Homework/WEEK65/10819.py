# BOJ 10819 차이를 최대로 - 실버 2
# 순열 라이브러리 사용
import sys
from itertools import permutations

n = int(input())
arr = list(map(int, input().split()))
answer = 0
p = list(permutations(arr, n))

for i in p:
    s = 0
    for j in range(n-1):
        s += abs(i[j] - i[j+1])
    answer = max(answer, s)

print(answer)