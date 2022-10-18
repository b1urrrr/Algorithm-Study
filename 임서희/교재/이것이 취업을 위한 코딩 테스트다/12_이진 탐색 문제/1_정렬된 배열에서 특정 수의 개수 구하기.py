from bisect import bisect_left, bisect_right # 파이썬 이진 탐색 라이브러리

n, x = map(int, input().split())
li = list(map(int, input().split()))

def find(array, left_value, right_value):
	right_i = bisect_right(array, right_value)
	left_i = bisect_left(array, left_value)
	return right_i - left_i

count = find(li, x, x)

if count == 0:
	print(-1)
else:
	print(count)