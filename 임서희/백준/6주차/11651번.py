import sys
N = int(sys.stdin.readline())
a = []

for i in range(N):
    x, y = map(int, sys.stdin.readline().split())
    a.append((x,y))

a.sort(key=lambda x: (x[1],x[0]))

for i in range(len(a)):
    print(f'{a[i][0]} {a[i][1]}')