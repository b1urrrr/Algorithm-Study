n = int(input())
li = list()

for _ in range(n):
	li.append(int(input()))

li = sorted(li)
res = li[0]

for i in range(1, n):
	res += (res+li[i])

print(res)