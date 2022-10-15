# 정렬
# 11557번: Yangjojang of The Year
T = int(input())
for _ in range(T):
    n = int(input())
    li = []
    for i in range(n):
        li.append(list(map(str, input().split())))
    li = sorted(li, key=lambda x:int(x[1]))
    print(li[n-1][0])
