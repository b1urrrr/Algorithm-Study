# 내 코드
tel = input()
time = 0

for i in tel:
    print(i)
    if i in 'ABC':
        time += 3
    elif i in 'DEF':
        time += 4
    elif i in 'GHI':
        time += 5
    elif i in 'JKL':
        time += 6
    elif i in 'MNO':
        time += 7
    elif i in 'PQRS':
        time += 8
    elif i in 'TUV':
        time += 9
    elif i in 'WXYZ':
        time += 10
    else:
        time += 11

print(time)


# 다른 코드: 리스트 이용하기
a = input()
num = ['ABC', 'DEF', 'GHI', 'JKL', 'MNO', 'PQRS',
       'TUV', 'WXYZ']  # 0 1 2 3 4 5 6 7 -> +3
b = 0
for i in a:
    for j in num:
        if i in j:
            b += num.index(j) + 3

print(b)
