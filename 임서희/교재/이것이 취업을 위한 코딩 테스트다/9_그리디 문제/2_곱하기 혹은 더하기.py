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

# 답안 예시
n = int(input())
data = list(map(int, input().split()))

result = 0

count = 0 

for i in data:
    count += 1
    if count >= i:
        result += 1
        count =0
print(result)