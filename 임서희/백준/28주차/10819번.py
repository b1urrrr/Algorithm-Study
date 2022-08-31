# 백트래킹
# 10819번: 차이를 최대로
# 조금 더 생각해보기 → 푸는 방법은 알겠는데 코드로 만드는게 어려워서 고민해보기
n = int(input())
s = list(map(int, input().split()))
su = []
max = 0

def dfs(start, next):
    if len(su) == n:
        print(' '.join(map(str,su)))
        #sum = 0
        #for i in range(n-1):
        #    sum += abs(su[i]-su[i+1])
        #global max
        #if max <= sum:
        #    max = sum
        return
    for i in range(start, len(s)):
        su.append(s[i])
        dfs(i)
        su.pop()
dfs(0)
print(max)