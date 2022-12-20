# 그리디 알고리즘
# 13305번: 주유소
# 지난번에 부분 점수 받아서 다른 코드 참고해서 추가
n = int(input())
r = list(map(int,input().split()))
c = list(map(int, input().split()))
res = 0
m = c[0]
for i in range(n-1):
    if c[i] < m:
        m = c[i]
    res += m* r[i]
print(res)