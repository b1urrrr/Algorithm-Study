# 정렬, 구현
# 11536번: 줄 세우기
n = int(input())
li = []
for _ in range(n):
    li.append(input())
li_i = sorted(li)
li_d = sorted(li, reverse=True)
res = "NEITHER"

for i in range(n):
    if li_i[i] != li[i]:
        break
else:
    res = "INCREASING"

for i in range(n):
    if li_d[i] != li[i]:
        break
else:
    res = "DECREASING"

print(res)