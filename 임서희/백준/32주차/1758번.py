# 그리디 알고리즘, 정렬
# 1758번: 알바생 강호
n = int(input())
li = list()
for _ in range(n):
    li.append(int(input()))

li = sorted(li, reverse= True)
res = 0
for i in range(n):
    if li[i] - i > 0:
        res += (li[i]-i)
print(res)