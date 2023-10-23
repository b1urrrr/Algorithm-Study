# BOJ 11651 좌표 정렬하기 - 실버 5
import sys
n = int(sys.stdin.readline())
arr = []
for i in range(n):
    x, y = map(int, sys.stdin.readline().split())
    arr.append([y, x])

sort_arr = sorted(arr)

for y, x in sort_arr:
    print(x, y)