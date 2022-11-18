# 구현, 브루트포스
# 1977번: 완전제곱수
li = [i*i for i in range(1,101)]
m = int(input())
n = int(input())
res = []
for i in range(len(li)):
    if n < li[i]:
        break
    if m <= li[i] <=n:
        res.append(li[i])
if len(res) > 0:
    print(sum(res))
    print(res[0])
else:
    print(-1)