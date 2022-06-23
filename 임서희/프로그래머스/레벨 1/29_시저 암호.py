# 연습 문제
# 시저 암호
# chr(), ord() 알기

def solution(s, n):
    alpa= ['a','b','c','d','e','f','g','h','i','j','k','l',
           'm','n','o','p','q','r','s','t','u','v','w','x','y','z'] # 0~25
    result = ""
    for a in s:
        a = str(a)
        if a.isupper():
            a = a.lower()
            a = alpa[(alpa.index(a)+n)%26]
            a = a.upper()
        elif a.islower():
            a = alpa[(alpa.index(a)+n)%26]
        result += a      
    return result

# 다른 사람 코드 1
def caesar(s, n):
    s = list(s)
    for i in range(len(s)):
        if s[i].isupper():
            s[i]=chr((ord(s[i])-ord('A')+ n)%26+ord('A'))
        elif s[i].islower():
            s[i]=chr((ord(s[i])-ord('a')+ n)%26+ord('a'))

    return "".join(s)

# 다른 사람 코드 2
def solution(s, n):
    answer = ''
    for i in s:
        if i:
            if i >= 'A' and i <= 'Z':
                answer += chr((ord(i) - ord('A') + n) % 26 + ord('A'))
            elif i >= 'a' and i <= 'z':
                answer += chr((ord(i) - ord('a') + n) % 26 + ord('a'))
            else : answer += ' '
    return answer
