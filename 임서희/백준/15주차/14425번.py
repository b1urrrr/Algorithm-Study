# 집합과 맵
# 14425번: 문자열 집합
n, m = map(int, input().split())
s = []
count = 0

for _ in range(n):
    s.append(input())
    
for _ in range(m):
    a = input()
    if a in s:
        count+=1

print(count)

# 더 빠른 다른 사람 코드
import sys

N, M = map(int, input().split())
S = set()
num = 0
for i in range(N):
    S.add(sys.stdin.readline().rstrip())
for i in range(M):
    check = sys.stdin.readline().rstrip()
    if check in S:
        num += 1
print(num)