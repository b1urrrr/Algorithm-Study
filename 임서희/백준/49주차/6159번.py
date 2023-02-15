# 브루트포스 알고리즘
# 6159번: 코스튬 파티

# 내 코드: 시간초과 -> 더 생각해보기
n, s = map(int, input().split())
li = []
for i in range(n):
    li.append(int(input()))

li_s = set()
for i in range(n):
    for j in range(n):
        if i == j:
            continue
        if (li[i]+li[j]) <= 6:
            li_s.add((li[i],li[j]))
print(len(li_s)//2)
