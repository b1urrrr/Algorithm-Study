n = int(input())
data = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())

min_value = 1e9 # 최솟값
max_value = -1e9 # 최댓값

def dfs(i, now):
    global min_value, max_value, add , sub, mul, div
    if i == n:
        min_value = min(min_value,now)
        max_value = max(max_value, now)
    else:
        if add > 0 :
            add -= 1
            dfs(i + 1, now + data[i])
            add += 1
        if sub > 0:
            sub -= 1
            dfs(i+1, now - data[i])
            sub += 1
        if mul > 0:
            mul -= 1
            dfs(i+1, now*data[i])
            mul += 1
        if div > 0:
            div -= 1
            dfs(i+1, int(now/data[i]))
            div += 1
dfs(1, data[0])
print(max_value)
print(min_value) 