# 1. 내 풀이
A = int(input())
B = int(input())
C = int(input())

n = A*B*C
a = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

while True:
    i = n % 10
    a[i] += 1
    n = n // 10
    if n == 0:
        break

for i in range(10):
    print(a[i])


# 2. 다른 풀이(참고): 문자열 취급
A = int(input())
B = int(input())
C = int(input())

result = list(str(A*B*C))
for i in range(10):  # 0~9까지의 문자가 result에 몇 번 나오는지 count
    print(result.count(str(i)))
