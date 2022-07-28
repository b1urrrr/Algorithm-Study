# 수학
# 1094번: 막대기
a = int(input())
cnt = 0
while a != 0:
    if a % 2 == 1:
        cnt += 1
    a = a // 2
print(cnt)