import sys
N = int(sys.stdin.readline())
a = []

for i in range(N):
    age, name = map(str, sys.stdin.readline().split())
    a.append((int(age),name))

a.sort(key=lambda x: x[0])

for i in range(len(a)):
    print(f'{a[i][0]} {a[i][1]}')