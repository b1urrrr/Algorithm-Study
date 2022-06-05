# dfs
# 2667번: 단지 번호 붙이기

# 내 코드: RecursionError 발생
n = int(input())
graph = []
for i in range(n):
    graph.append(list(map(int,input())))

number = 1

def dfs(x,y):
    if x <= -1 or x >= n or y <= -1 or y >= n:
        return False
    if graph[x][y] == 1:
        graph[x][y] = number
        dfs(x-1,y)
        dfs(x,y-1)
        dfs(x+1,y)
        dfs(x,y+1)
        return True
    return False

for i in range(n):
    for j in range(n):
        if dfs(i,j) == True:
            number += 1
            
for i in range(n):
    print(graph[i])

house = [0] * (number+2)
for i in range(n):
    for j in range(n):
        house[graph[i][j]] += 1
    
for i in house[2:]:
    print(i,end=' ')