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

# 코드 2
n = int(input())
i = 11
num = 2
if n == 1:
    print(1)
elif n % 2 == 0 or n % 5 == 0:
    print(-1)
else:
    while i % n != 0:
        i = i % n
        i = i * 10 + 1
        num+=1
    print(num)