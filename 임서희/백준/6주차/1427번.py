N = int(input())
a = N
s_list = []

while a > 0:
    s_list.append(a%10)
    a = a // 10

s_list.sort(reverse=True)

for num in s_list:
    print(num, end='')