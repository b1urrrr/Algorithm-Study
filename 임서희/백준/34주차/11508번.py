# 정렬, 그리디
# 11508번: 2+1 세일
n=int(input())
c=[]
for i in range(n):
  c.append(int(input()))
c.sort(reverse=True)

result=0
for i in range(2,len(c),3):
  result+=c[i]

print(sum(c)-result)