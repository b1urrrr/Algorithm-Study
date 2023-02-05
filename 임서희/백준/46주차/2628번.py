# 정렬
# 2628번: 종이 자르기
m, n = map(int, input().split())
t = int(input())
n_l = []
m_l = []
for _ in range(t):
    a, b = map(int, input().split())
    if a == 0:
        n_l.append(b)
    else:
        m_l.append(b)
n_l = sorted(n_l)
m_l = sorted(m_l)

res_n = []
res_m = []
start = 1
for i in range(len(n_l)):
    res_n.append(abs(start-n_l[i])+1)
    start = n_l[i]+1
if start != n:
    res_n.append(abs(start-n)+1)

start = 1
for i in range(len(m_l)):
    res_m.append(abs(start-m_l[i])+1)
    start = m_l[i]+1
if start != m:
    res_m.append(abs(start-m)+1)
    
res = []
for i in res_n:
    for j in res_m:
        res.append(i*j)
res = sorted(res)
print( res[len(res)-1])