N, K = map(int, input().split())

def fac(n):
    res = 1
    for i in range(1,n+1):
        res = res*i
    return res

result = fac(N)//(fac(K)*fac(N-K))
print(result)