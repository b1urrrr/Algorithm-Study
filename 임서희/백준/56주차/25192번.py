# 해시를 사용한 집합과 맵
# 25192번: 인사성 밝은 곰곰이

n = int(input())
d = dict()
res = 0

for _ in range(n):
    i = input()
    if i == 'ENTER':
        d = dict()
        continue
    if i not in d:
        d[i] = 1
        res += 1
        
print(res)