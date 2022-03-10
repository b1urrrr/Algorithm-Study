alpa = [-1] * 26

s = list(input())

# ord(a)는 97
for i in range(len(s)):
    if alpa[ord(s[i])-97] == -1:
        alpa[ord(s[i])-97] = i

for i in range(26):
    print(alpa[i], end=' ')

# 2. index() 활용해서 코드 작성하는 방법 존재
