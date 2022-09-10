# 백트래킹
# 19949번: 영재의 시험
n = list(map(int, input().split()))
sum = 0
su = []

def dfs():
    if sum(su) == 5:
        sum += 1
        return
    for i in range(len(n)):
        su.append(i)
        dfs()
        su.pop()

