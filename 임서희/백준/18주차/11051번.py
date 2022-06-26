# 집합과 조합론
# 11051번: 이항 계수2
# 런타임 에러: 0으로 나눴을 때 문제
N, K = map(int, input().split())

d = [0]*1001

def fac(n):
    if d[n] != 0:
        return d[0]
    else:
        res = 1
        for i in range(1,n+1):
            res = res*i
        d[n] = res
        return d[n]

result = fac(N)//(fac(K)*fac(N-K))
if result >= 10007:
    result %= 10007
print(result)