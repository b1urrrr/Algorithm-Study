# 정렬, 그리디 알고리즘
# 6068번: 시간 관리하기

# 코드 틀림 
# 내 코드
n = int(input())
li = []

for _ in range(n):
    li.append(list(map(int, input().split())))

li = sorted(li, key = lambda x: x[1])

time = 0
for i in range(n):
    time += li[i][0]
    if time > li[i][1]:
        print(-1)
        break

#print(time)
print(abs(li[0][0]-li[0][1]))

# 다른 사람 코드 참고해서 수정한 코드
n = int(input())
li = []

for _ in range(n):
    li.append(list(map(int, input().split())))

li = sorted(li, key = lambda x: x[1])

time = 0
limit_time = 1e9
for i in range(n):
    #print(t, s)
    time += li[i][0]
    if time > li[i][1]:
        print(-1)
        break
    limit_time = min(limit_time, li[i][1]-time)
else:
    print(limit_time)