# 그리디 알고리즘
# 1246번: 온라인 판매
n , m = map(int, input().split())
p = list()
for _ in range(m):
    p.append(int(input()))
p = sorted(p, reverse=True)
max_p = 0
result_p = 0
for i in range(min(n,m)):
    res = p[i]*(i+1)
    if res >= max_p:
        result = p[i]
        max_p = res
print(result, max_p)
