# 정렬
# 17224번: APC는 왜 서브태스크 대회가 되었을까?
N,L,K = map(int, input().split())
 
arr = []
for _ in range(N):
    sub1, sub2 = map(int, input().split())
    arr.append([sub1,sub2])
    arr.sort(key=lambda x:x[1])
 
score = 0
k = 0
for i in arr:
    if k == K:
        break
        
    if i[1] <= L:
        score += 140
        k += 1
    elif i[0] <= L:
        score += 100
        k += 1
 
print(score)