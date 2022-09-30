# 문자열, 시뮬레이션
# 1551번: 수열의 변화
N, K = map(int, input().split())
li = list(map(int, input().split(',')))
for _ in range(K):
    t = [li[i+1]-li[i] for i in range(len(li)-1)]
    li = t
print(*li, sep=',')