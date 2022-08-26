# 백트래킹
# 15649번: N과 M(1)

n, m = map(int, input().split()) # n은 1~n까지의 숫자, m은 수열의 길이

su = [] # 반환할 수열

def dfs(): # 백트래킹은 dfs를 이용하여 문제 풀이
    if len(su) == m: # 반환할 수열의 길이가 수열의 길이 m과 같으면 출력 후 return
        print(' '.joing(map(str,su)))
        return
    for i in range(1,n+1): # 1~n
        if i not in su:
            su.append(i)
            dfs()
            su.pop()
dfs() # 함수 시작