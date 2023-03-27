# 그리디 알고리즘
# 25176번: 청정수열
n=int(input())
a=1
for i in range(1,n+1):
  a *= i
print(a)