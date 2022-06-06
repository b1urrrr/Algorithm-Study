# 그리디 알고리즘
# 13305번: 주유소
# 17점: 답은 나오는데 서브태스크가 틀려서 다시 풀어보기
import sys
n = int(sys.stdin.readline())
length = list(map(int,sys.stdin.readline().split()))
oil = list(map(int, sys.stdin.readline().split()))
cost = length[0] * oil[0]
min_oil = max(oil)

for i in range(1, len(length)):
    if min_oil >= oil[i]:
        cost += oil[i]*length[i]
        min_oil = oil[i]
    else:
        cost += min_oil*length[i]

print(cost)