# 정렬
# 2693번: N번째 큰 수
T = int(input())

for _ in range(T):
    a = list(map(int, input().split()))
    a = sorted(a, reverse=True)
    print(a[2])