# 정렬
# 7795번: 먹을 것인가 먹힐 것인가
t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    res = 0
    a = sorted(list(map(int, input().split())), reverse=True)
    b = sorted(list(map(int, input().split())))
    for i in b:
        for j in a:
            if i >= j:
                break
            else:
                res += 1
    print(res)