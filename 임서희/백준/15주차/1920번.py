# 이진 탐색
# 내 코드 : 272ms
import sys
n = int(sys.stdin.readline())
arr = list(map(int,sys.stdin.readline().split()))

arr.sort()

m = int(sys.stdin.readline())
f = list(map(int, sys.stdin.readline().split()))

def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        if array[mid] == target:
            return 1
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return 0

for i in range(m):
    print(binary_search(arr, f[i], 0, n-1))
        
# 다른 사람 코드 : 193ms
n = int(input())
a = set(list(map(int, input().split())))
m = int(input())
b = list(map(int, input().split()))

for i in b:
    if i in a:
        print(1)
    else:
        print(0)