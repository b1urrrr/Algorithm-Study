# 정렬
# 16466번: 콘서트
n = int(input())
li = list(map(int, input().split()))
li.sort()
k = 1
for i in range(li[n-1]):
    if li[i] != k:
        print(k)
        break
    else:
        k+=1
else:
    print(k)