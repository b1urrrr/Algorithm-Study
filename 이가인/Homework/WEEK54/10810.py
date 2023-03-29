# 백준 10810
n, m = map(int, input().split())
basket = [0] * n
for _ in range(m):
    i, j, k = map(int, input().split())
    for a in range(i-1, j, 1):
        basket[a] = k

for a in range(n):
    print(basket[a], end=' ')
            
