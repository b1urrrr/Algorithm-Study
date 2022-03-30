# 메모리 초과 (힙 정렬도 똑같이 메모리 초과)
import sys

N = int(sys.stdin.readline())
a = []

for i in range(N):
    s = int(sys.stdin.readline())
    a.append(s)
a.sort()
for i in range(len(a)):
    print(a[i])