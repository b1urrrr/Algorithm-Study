# 내 코드
n,m = map(int, input().split())
li = list(map(int, input().split()))
new = []

for i in range(len(li)-1):
    for j in range(i+1, len(li)):
        if li[i] != li[j]:
            new.append((i,j))
          
#print(new)
print(len(new))