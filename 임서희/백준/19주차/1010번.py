# 정수론 및 조합론
# 1010번: 다리 놓기

def factorial(n):
    num = 1
    for i in range(1, n+1):
        num *= i
    return num


T = int(input())

for _ in range(T):
    n, m = map(int, input().split())
    bridge = factorial(m) // (factorial(n) * factorial(m - n))
    print(bridge)

# 팩토리얼 이용하는 것까지 이해했는데 식을 만들지 못했음
# 추후 다시 풀어보기!