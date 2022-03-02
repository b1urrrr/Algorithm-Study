N, X = map(int, input().split())
a = list(map(int, input().split()))

for i in range(N):
    if a[i] < X:
        print(a[i], end=" ")
