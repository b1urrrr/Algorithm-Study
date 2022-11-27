# 정렬, 그리디 알고리즘
# 11256번: 사탕
t = int(input())
for _ in range(t):
    j, n = map(int, input().split()) # 사탕 개수 j, 상자 개수 n
    li = []
    for i in range(n):
        h, w = map(int,input().split())
        li.append(h * w)
    li = sorted(li, reverse=True)
    res = 0
    for i in li:
        if j <= 0:
            print(res)
            break
        j -= i
        res += 1