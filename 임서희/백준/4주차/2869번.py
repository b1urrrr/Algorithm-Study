# 틀린 내 코드
A, B, V = map(int, input().split())
day_meter = V/(A-B)
N = 1

while N < day_meter:
    N += 1

if day_meter == V:
    N -= 1
    
print(N)

# 정상적인 남의 코드
import math
A,B,V = map(int,input().split())
print(math.ceil((V-A)/(A-B)+1))