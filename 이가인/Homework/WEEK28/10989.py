# 1st try
# 입력값을 배열에 저장하고 정렬하면 메모리 초과가 뜬다
# n = int(input())
# arr = []
# for _ in range(n):
#     i = int(input())
#     arr.append(i)
# arr.sort()
# for _ in range(len(arr)):
#     print(arr[_])
##
# 2nd try

import sys
n = int(sys.stdin.readline())
arr = [0] * 10001

for i in range(n):
    data = int(sys.stdin.readline())
    arr[data] +=1

for i in range(10001):
    if arr[i] != 0:
        for j in range(arr[i]):
            print(i)