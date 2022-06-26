# 브루트포스
# 1057번: 토너먼트
# 68ms, 30840ms
n, a, b = map(int, input().split())
res = 1
if a > b:
    a, b = b, a
while n > 0:
    if b % 2 == 0 and b-a == 1:
        break
    if b%2 !=0:
        b /= 2
        b = int(b) + 1
    else:
        b //= 2
    if a%2 != 0:
        a /= 2
        a = int(a) + 1
    else:
        a //= 2
    res += 1
    n //= 2
else:
    res = -1
print(res)

# 다른 사람 코드
# 76ms, 32952kb
import sys
import math
R,N,M=map(int,sys.stdin.readline().split())
cnt=0
while N!=M:
    N=math.ceil(N/2)
    M=math.ceil(M/2)
    cnt+=1
print(cnt)