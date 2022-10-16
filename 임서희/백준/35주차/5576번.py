# 정렬
# 5576: 콘테스트
l = []
for _ in range(20):
    l.append(int(input()))
w = sorted(l[:10],reverse=True)
k = sorted(l[10:],reverse=True)

print(sum(w[:3]), sum(k[:3]))