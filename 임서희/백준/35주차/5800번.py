# 정렬
# 5800번: 성적 통계
t = int(input())

for i in range(1,t+1):
    n = list(map(int, input().split()))
    a = n[0]
    l = sorted(n[1:],reverse=True)
    d = []
    for j in range(len(l)-1):
        d.append(abs(l[j+1] - l[j]))
    print("Class", i)
    print("Max " + str(l[0]) + ", Min " + str(l[a-1]) + ", Largest gap " + str(max(d)))
