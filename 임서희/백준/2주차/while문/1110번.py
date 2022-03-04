# 내가 쓴 틀린 답
# n1 = int(input())
# sum = 0
# if n1 != 0:
#    sum += 1
# a = n1 // 10
# b = n1 % 10
# n2 = b*10 + (a+b)%10
# while (n2 != n1):
#    sum += 1
#    a = n2 // 10
#    b = n2 % 10
#    n2 = b*10 + (a+b)%10
# print(sum)

# 맞는 답
n = int(input())
num = n
sum = 0

while True:
    a = num // 10
    b = num % 10
    c = (a+b) % 10
    num = b*10 + c

    sum += 1
    if (num == n):
        break

print(sum)
