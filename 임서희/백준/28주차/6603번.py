# 백트래킹
# 6603번: 로또
def dfs(start):
    if len(su) == 6:
        print(' '.join(map(str, su)))
        return
    for i in range(start, len(s)):
        su.append(s[i])
        dfs(i+1)
        su.pop()
        
while True:
    n = list(map(int, input().split()))
    k = n[0]
    if k == 0:
        break
    s = [n[i] for i in range(1,len(n))]
    su = []
    
    dfs(0)
    print() # 처음에 줄바꿈 안넣어줬다가 출력 형식이 틀리다고 나와서 추가해줌

# 다른 사람의 경우, combinations 함수를 사용하여 푸는 경우도 있었음