# 그리디 알고리즘
# 1789번: 수들의 합
s = int(input())
l = 0
res = 0
for i in range(1, s+1):
    l += i
    res += 1
    if l > s:
        res -= 1
        break
    
print(res)