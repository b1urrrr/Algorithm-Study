t = int(input())
for i in range(t):
    k = int(input())
    n = int(input())
    a = [x for x in range(1, n+1)]
    for k in range(k):
        for j in range(1, n):
            a[j] += a[j-1]
    print(a[-1])