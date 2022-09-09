# 백트래킹
# 15664번: N과 M(10)
# 집합을 이용해서 중복 없애는 방법 고안해서 다시 풀어보기
n, m = map(int, input().split())
n_list = sorted(list(map(int, input().split())))
su = set()
a = set()

def dfs():
    if len(a) == m:
        su.add(a)
        return
    for i in range(len(n_list)):
        a.add(n_list[i])
        dfs()
        a = set()


n, m = map(int, input().split())
nums = sorted(list(map(int, input().split())))
visited = [False] * n
temp = []

def dfs(start):
    if len(temp) == m:
        print(*temp)
        return
    remember_me = 0
    for i in range(start, n):
        if not visited[i] and remember_me != nums[i]:
            visited[i] = True
            temp.append(nums[i])
            remember_me = nums[i]
            dfs(i + 1)
            visited[i] = False
            temp.pop()

dfs(0)