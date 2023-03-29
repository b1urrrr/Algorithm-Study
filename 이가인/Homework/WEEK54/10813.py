# 백준 10813

n, m = map(int, input().split())

balls = [1] * n

for k in range(n):
    balls[k] = k+1

for _ in range(m):
    i, j = map(int, input().split())
    tmp = balls[i-1]
    balls[i-1] = balls[j-1]
    balls[j-1] = tmp

for k in range(n):
    print(balls[k], end=" ")
