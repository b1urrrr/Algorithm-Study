# 1003번: 피보나치 함수
# 다이나믹 프로그래밍
T = int(input())

def fibonacci(n):
    if n==0:
        global sum_0
        sum_0 += 1
        return 0
    elif n==1:
        global sum_1
        sum_1 += 1
        return 1
    else:
        return fibonacci(n-1)+fibonacci(n-2)

for _ in range(T):
    global sum_0, sum_1
    sum_0 = 0
    sum_1 = 0
    num = int(input())
    fibonacci(num)
    print(f'{sum_0} {sum_1}')