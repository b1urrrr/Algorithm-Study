# 문자열
# 10813번: 공 바꾸기
n, m = map(int, input().split())

b = [i for i in range(1,n+1)]

for i in range(m):
    i,j = map(int, input().split())
    b[i-1], b[j-1] = b[j-1], b[i-1]

for i in range(n):
    print(b[i], end = ' ')