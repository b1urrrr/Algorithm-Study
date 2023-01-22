# 정렬
# 1822번: 차집합
n, m = map(int, input().split())
n_l = set(map(int, input().split()))
m_l = set(map(int, input().split()))
res = sorted(list(n_l - m_l))
print(len(res))
for i in res:
    print(i, end=' ')
