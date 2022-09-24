# 다시 풀기
n = int(input())
li = sorted(list(map(int, input().split())))
res = 1
print(li)

while True:
    s = 0
    for i in range(len(li)-1, 0, -1):
        if s+li[i] > res:
            continue
        elif s == res:
            print(res)
            break
        s += li[i]
    if s != res:
        print(res)
        break
    res += 1
    