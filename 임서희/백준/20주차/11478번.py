# 11478번: 서로 다른 부분 문자열의 개수
import sys

s = list(map(str, sys.stdin.readline()))
a = set() 

for i in range(len(s)):
    for j in range(len(s) + 1):
        if s[i:j]:
            a.add("".join(s[i:j]))
print(len(a))