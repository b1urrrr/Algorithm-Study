# 문자열, 구현
# 1371번: 가장 많은 글자
# 예제 결과는 동일한데 틀림 -> 입력 받는 부분이 잘못된 듯
# 다시 풀기
li = list(map(str, input().split()))
alpha = dict()

for i in li:
    for k in i:
        if k not in alpha:
            alpha[k] = 1
        else:
            alpha[k] += 1

max_list = [k for k,v in alpha.items() if max(alpha.values()) == v]
max_list = sorted(max_list)
res = ''
for i in max_list:
    res += i
print(res)

import sys
input = sys.stdin.read

s = input().replace("\n","").replace(" ","")
c = [0] * 26
for i in s:
    c[ord(i)-97]+=1
    
maxx = max(c)
r = []
for i in range(len(c)):
    if c[i] == maxx:
        r.append(chr(i+97))
        
r.sort()
print(*r,sep="")