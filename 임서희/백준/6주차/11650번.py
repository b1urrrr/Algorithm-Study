# key=lambda 정렬 다시 이해하기!
# import sys로 시간 줄이기
N = int(input())
a = []

for i in range(N):
    x, y = map(int, input().split())
    a.append((x,y))

a.sort(key=lambda x: (x,y)) # x[0] x[1]

for i in range(len(a)):
    print(f'{a[i][0]} {a[i][1]}')