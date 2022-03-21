# 내 코드1: 시간 76ms
N = int(input())
sum = 0

a = list(map(int, input().split()))

for num in a:
    if num > 1:
        for i in range(2,num):
            if num % i == 0:
                break
        else:
            sum += 1
print(sum)

# 내 코드2: 시간 72ms
N = int(input())
sum = N

a = list(map(int, input().split()))

for num in a:
    if num == 1:
        sum -= 1
    else:
        k = num - 1
        while k > 1:
            if num%k == 0:
                sum -= 1
                break
            k -= 1
print(sum)

# 내 코드3: 시간 80ms
N = int(input())
sum = N

a = list(map(int, input().split()))

for i in range(len(a)):
    if a[i] == 1:
        sum -= 1
        continue # 처음에 continue 말고 break 써서 틀림!
    k = a[i] - 1
    while k > 1:
        if a[i]%k == 0:
            sum -= 1
            break
        k -= 1
print(sum)