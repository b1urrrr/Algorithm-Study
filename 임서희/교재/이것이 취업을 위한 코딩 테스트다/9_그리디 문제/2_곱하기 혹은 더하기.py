# 내 코드
n = input()
n = sorted(n)
res = 1

for i in n:
	if int(i) == 0:
		continue
	else:
		res *= i

print(res)