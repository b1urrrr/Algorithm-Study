# 브루트포스
# 15721번: 번데기
a = int(input())
t = int(input()) # 원하는 뻔 or 데기 횟수
s = int(input()) # 뻔:0 데기:1

n = 1 # n회차
cnt = 0 # 뻔 or 데기 횟수
member = 1
while True:
    if cnt == t:
        break
    li = '0101' + '0'*(n+1) + '1'*(n+1)
    for i in li:
        if member > a:
            member = 1
        print(i, member)
        if int(i) == s:
            cnt += 1
        if cnt == t:
            break
        member += 1
    n+=1
print(member-1)