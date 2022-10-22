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

# 위에 내 코드가 틀려서 다른 코드
# ord로 아스키코드로 변환해야 할 듯
cnt=1
while 1:
    a=input()
    b=input()
    if a=='END' and b=='END' :break
    tmpa,tmpb=[0]*26, [0]*26
    for i in a: tmpa[ord(i)-97]+=1
    for i in b: tmpb[ord(i) - 97] += 1
    if tmpa==tmpb: print("Case %d: same"%cnt)
    else: print("Case %d: different"%cnt)
    cnt+=1