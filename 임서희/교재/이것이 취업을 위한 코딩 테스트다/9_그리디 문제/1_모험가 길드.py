# 내 코드
N = int(input())
scary = list(map(int, input().split()))
scary = sorted(scary)
count = 0
i = 0

while i < scary[i]:
    count += 1
    i += scary[i]

print(count)

# 답안 코드
n = int(input())
data = list(map(int, input().split()))
data.sort()

result = 0 # 총 그룹의 수
count = 0

for i in data:
	count += 1
	if count >= i:
		result += 1
		count = 0

print(result)