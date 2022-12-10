# 10886번: 0 = not cute/ 1 = cute
n = int(input())
num1 = 0
num0 = 0
for _ in range(n):
    i = int(input())
    if i == 1:
        num1 += 1
    else:
        num0 += 1
if num1 > num0:
    print("Junhee is cute!")
else:
    print("Junhee is not cute!")