# 구현
# 2444번: 별 찍기 - 7
n = int(input())

for i in range(1,n+1):
    print(" "*(n-i) + "*"*(2*i-1))
k = 1
for i in range(n-1, 0, -1):
    print(" "*k + "*"*(2*i-1))
    k+=1

# 다른 코드
for i in range(1, n+1):
    print(" "*(n-i)+"*"*(2*i-1))
for i in range(n-1, 0, -1):
    print(" "*(n-i)+"*"*(2*i-1)) # k대신 n-i 사용하기