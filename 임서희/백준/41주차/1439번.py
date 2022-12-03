# 그리디 알고리즘
# 1439번: 뒤집기
s = list(input())
li_0 = 0
li_1 = 0
pre = s[0]

if pre == '0':
    li_0 += 1
else:
    li_1 += 1
for i in range(1, len(s)):
    if pre != s[i]:
        if pre == '0':
            li_1 += 1
        else:
            li_0 += 1
        pre = s[i]
print(min(li_0,li_1))

