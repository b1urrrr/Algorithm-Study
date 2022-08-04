# 1120번: 문자열
#a, b = map(str, input().split())
a="adaabc"
b="aababbc"
res = []
cnt = 0
while cnt < len(b)-len(a): 
    for i in range(len(a)): # for문 범위 다시 지정하기
        n = 0
        for j in range(cnt, len(a)+cnt):
            print(a[i],b[j])
            if a[i] != b[j]:
                n += 1
    res.append(n)
    cnt += 1
print(res)
print(min(res))