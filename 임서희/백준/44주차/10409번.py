# 수학, 구현
# 10409번: 서버
n, t = map(int, input().split())
li = list(map(int, input().split()))
cnt = 0
res = 0
for i in li:
    res += i
    if res <= t:
        cnt += 1
    else:
        break
print(cnt)