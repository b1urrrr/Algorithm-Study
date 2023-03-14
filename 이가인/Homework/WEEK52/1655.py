# 첫번째 풀이 - 시간초과
# n = int(input())
# nums = []

# res = 1
# for i in range(n):
#     m = int(input())
#     nums.append(m)
#     nums.sort()
#     res = nums[int((len(nums)-1)/2)]
#     print(res)
    
# 두번째 풀이 - 두 개의 힙 사용
import sys
import heapq
input = sys.stdin.readline

n = int(input())
max_h, min_h = [], []

for i in range(n):
    m = int(input())
    if len(max_h) == len(min_h):
        heapq.heappush(max_h, -m)
    else:
        heapq.heapreplace(min_h, m)
    
    if len(max_h) >= 1 and len(min_h) >= 1 and max_h[0] * -1 > min_h[0]:
        max_value = heapq.heappop(max_h) * -1
        min_value = heapq.heappush(min_h, max_value)
        
    print(max_h[0] * -1)
