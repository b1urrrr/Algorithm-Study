# 내 코드: 실패(시간 초과)
import sys
M, N = map(int, sys.stdin.readline().split())

for num in range(M,N+1):
    if num > 1:
        for i in range(2, num):
            if num %i==0:
                break
        else:
            print(num)

# 에라토스테네스의 체: 시간 6036ms
# 시간이 너무 걸린다.
import sys
M, N = map(int, sys.stdin.readline().split())

for num in range(M,N+1):
    if num > 1:
        for i in range(2, int(num**0.5)+1):
            if num %i==0:
                break
        else:
            print(num)

# 다른 사람 코드: 시간 320ms
import sys
def solve():
    m,n = map(int,sys.stdin.readline().split())
    primes = [True] * ( n+1)
    primes[1] = False
    for i in range(2,n+1):
        if primes[i]:
            for j in range(2*i,n+1,i):
                primes[j] = False
    for i in range(m,n+1):
        if primes[i]:
            print(i)
solve()
 



