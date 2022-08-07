# 1612번: 가지고 노는 1
n = int(input())
i = 1
if n%2==0 or n%5==0:
    print(-1)
else:
    while True:
        a = int('1'*i)
        if a%n == 0:
            print(i)
            break
        i += 1