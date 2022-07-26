# 정렬, 브루트포스 알고리즘
# 1059번: 좋은 구간

# n이 10이고 8과 13 사이를 구간이라고 할 때라고 가정하고 공식을 세우면
# 10보다 작은 수의 개수*(10을 포함한 10보다 큰 수의 개수 + 10보다 큰 수의 개수)
import sys
L = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().split()))
n = int(sys.stdin.readline())
nums.sort()  # 두 수 사이에 있는 n을 찾아야 하므로 정렬
if n in nums:
    print(0)
else:
    min = 0
    max = 0
    for num in nums:            # 배열중에서 n과 가장 근접한 두 수를 구한다.
        if num < n:     
            min = num
        elif num > n and max == 0:
            max = num
    max -= 1                    # 1과 7사이에 n이 2이면 1과 7은 제외
    min += 1
    print((n-min)*(max-n+1) + (max-n))
    # n보다 작은 수와 만족할 경우 + n보다 큰 수와 만족할 경우