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

# 다시 풀기
# 다른 풀이
def dfs(depth):
    global cnt
    if depth == 10:
        s = 0
        for j in range(10):
            if li[j] == ans[j]:
                s += 1
        if s >= 5:
            cnt += 1
        return 
    for i in range(1, 6):
        if depth > 1 and li[depth-2] == li[depth-1] == i:
            continue
        li.append(i)
        dfs(depth+1)
        li.pop()
        
ans = list(map(int, input().split()))
li, cnt = [], 0
dfs(0)
print(cnt)