# 수학
# 2588번: 곱셈
a = int(input())
b = input()

for i in b[::-1]:
    print(a*int(i))
print(a*int(b))