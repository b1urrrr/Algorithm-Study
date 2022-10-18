n, c= list(map(int, input().split()))

li = list()
for _ in range(n):
	li.append(int(input()))

start = 1
end = li[-1] - li[0]
result = 0

while(start <= end):
	mid = (start+end)//2
	value = li[0]
	count = 1
	for i in range(1, n):
		if li[i] >= value + mid:
			value = li[i]
			count += 1
		if count >= c:
			start = mid+1
			result = mid
		else:
			end = mid - 1
print(result)