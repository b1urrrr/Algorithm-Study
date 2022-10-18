n = int(input())
li = list(map(int, input().split()))

def binary_search(li, start, end):
	if start > end:
		return None
	mid = (start + end) // 2
	if li[mid] == mid:
		return mid
	elif li[mid] > mid:
		return binary_search(li, start, mid - 1)
	else:
		return binary_search(li, mid + 1, end)

i = binary_search(li, 0, n-1)

if i == None:
	print(-1)
else:
	print(i)