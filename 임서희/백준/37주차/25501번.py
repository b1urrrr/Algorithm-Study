# 재귀
# 25501번: 재귀의 귀재
global re
re = 0
def recursion(s, l, r):
    global re
    re = re + 1
    if l >= r: return 1
    elif s[l] != s[r]: return 0
    else: return recursion(s, l+1, r-1)

def isPalindrome(s):
    return recursion(s, 0, len(s)-1)

t = int(input())
for _ in range(t):
    a = input()
    re = 0
    print(isPalindrome(a), re)
