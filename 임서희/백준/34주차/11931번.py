# 정렬
# 11931번: 수 정렬하기 4
# 시간 초과
t = int(input())
li = []
for _ in range(t):
    li.append(int(input()))
li = sorted(li, reverse=True)
for i in li:
    print(i)

# 다른 사람 코드
import sys
input = sys.stdin.readline

n = int(input())
l = [int(input()) for _ in range(n)]
l.sort(reverse=True)
for i in l:
    print(i)