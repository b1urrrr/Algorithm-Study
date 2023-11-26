# BOJ 16435 스네이크버드 - 실버 5
N, L= map(int, input().split())
h = list(map(int, input().split()))
h.sort()
for i in range(N):
    if h[i] <= L:
        L += 1

print(L)