# 브루트포스
# 1145번: 적어도 대부분의 배수
# 내 코드: 200ms
num = list(map(int, input().split()))
min_num = min(num)
while True:
    n = 0
    for i in num:
        if min_num%i == 0:
            n += 1
    if n >= 3:
        break
    else:
        min_num += 1
print(min_num)

# 다른 사람 코드: 60ms
from math import lcm
A=list(map(int,input().split()))
B=[]
for i in range(3):
    for j in range(i+1,4):
        for k in range(j+1,5):
            B.append(lcm(A[i],A[j],A[k]))
print(min(B))