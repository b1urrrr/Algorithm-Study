# 1269번: 대칭 차집합
n, m = map(int, input().split())

n_list = list(map(int, input().split()))
m_list = list(map(int, input().split()))

res = list(set(n_list)-set(m_list)) + list(set(m_list)-set(n_list))
print(len(res))