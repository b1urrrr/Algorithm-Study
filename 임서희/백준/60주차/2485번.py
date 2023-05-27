# 유클리드 호제법
# 2485번: 가로수
from math import gcd

n = int(input())
a = int(input())
arr = []

for i in range(n-1):
    num = int(input())
    arr.append(num-a)
    a = num

g = arr[0]
for i in range(1, len(arr)):
    g = gcd(g, arr[i])

result = 0
for i in arr:
    result += i//g-1
print(result)