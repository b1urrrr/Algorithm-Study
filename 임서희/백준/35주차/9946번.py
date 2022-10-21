# 정렬, 문자열
# 9946번: 단어 퍼즐
k = 1
while True:
    a = input()
    b = input()
    if a == 'END' and b == 'END':
        break
    a = sorted(a)
    b = sorted(b)
    res = ''
    for i in range(len(a)):
        if a[i] != b[i]:
            res = 'different'
            break
    else:
        res = 'same'
    print('Case ' + str(k) + ': ' + res)
    k += 1