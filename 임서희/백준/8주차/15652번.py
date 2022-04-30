N, M = map(int, input().split())
s = []

def dfs(start):
    if len(s) == M:
        print(' '.join(map(str,s)))
        return
    for i in range(1, N+1):
        if len(s) != 0:
            if i >= s[len(s)-1]:
                s.append(i)
                dfs(i)
                s.pop()
        else:
            s.append(i)
            dfs(i)
            s.pop()
        
dfs(1)
