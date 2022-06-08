# 동적 계획법
# 알고리즘 수업 - 피보나치 수 1
cnt1 = 1
def fib(n):
    global cnt1
    cnt1+=1
    if n == 1 or n == 2:
        cnt1 -= 1
        return 1
    else:

        return fib(n-1) + fib(n-2)


n = int(input())
f = [0] * (n+1)
cnt2 = 0
def fibonacci(n):
    f[1] = 1
    f[2] = 1
    global cnt2
    for i in range(3, n+1):
        cnt2+=1
        f[i] = f[i-1] + f[i-2]
    return f[i]

fib(n)
fibonacci(n)
print(cnt1, cnt2)