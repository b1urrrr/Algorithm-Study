# 정렬
# 9076번: 점수 집계
t = int(input())
for _ in range(t):
    li = sorted(list(map(int, input().split())))
    if abs(li[3] - li[1]) >= 4:
        print("KIN")
    else:
        print(sum(li[1:4]))
