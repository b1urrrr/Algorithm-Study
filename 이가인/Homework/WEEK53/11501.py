
t = int(input())

for _ in range(t):
    cnt = 0
    value = 0
    max = 0
    n = int(input())
    stock = list(map(int, input().split()))
    # 반복문을 뒤에서부터 접근
    for i in range(len(stock)-1, -1, -1):
        if (stock[i] > max):
            max = stock[i]
        else:
            value += max - stock[i]
    print(value)        
