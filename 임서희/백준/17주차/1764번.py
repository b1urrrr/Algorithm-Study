# 1764번: 듣보잡

n, m = map(int, input().split())
n_list = dict()
m_list = []

for _ in range(n):
    a = input()
    n_list[a] = 0
for _ in range(m):
    m_list.append(input())

result = []

for i in m_list:
    value = n_list.get(i) # 딕셔너리.get(찾고하자는 키)
    if value == None:
        continue
    else:
        result.append(i)
    #if i in n_list:
    #    result.append(i)

result = sorted(result)
for i in result:
    print(i)

# 틀려서 다시 풀기