# 집합
# 1764번: 듣보잡
n, m = map(int, input().split())
no_listen = []
no_see = []
for i in range(n):
    no_listen.append(input())
for i in range(m):
    no_see.append(input())

result = list(set(no_listen) & set(no_see))
result = sorted(result)
print(len(result))
for res in result:
    print(res)