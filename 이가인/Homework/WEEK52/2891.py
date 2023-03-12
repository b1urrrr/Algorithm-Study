# 첫번째 시도
# n, s, r = map(int, input().split())
# mistake = list(map(int, input().split()))
# life_saver = list(map(int, input().split()))

# cnt = 0

# for i in mistake:
#     if i-1 in life_saver:
#         mistake.remove(i-1)
#     elif i+1 in life_saver:
#         mistake.remove(i+1)
#     else:
#         cnt += 1

# print(cnt)

#두번째 시도
n, s, r = map(int, input().split())
mistake = list(map(int, input().split()))
life_saver = list(map(int, input().split()))

teamlist = [1] * n

for i in mistake:
    teamlist[i-1] = 0

for k in life_saver:
    teamlist[k-1] = 2

for j in range(len(teamlist)):
    if teamlist[j] == 0:
        if j == 0:
            if teamlist[j+1] == 2:
                teamlist[j+1] = 1
                teamlist[j] = 1
        elif j == len(teamlist)-1:
            if teamlist[j-1] == 2:
                teamlist[j-1] = 1
                teamlist[j] = 1
        else:
            if teamlist[j-1] == 2:
                teamlist[j-1] = 1
                teamlist[j] = 1
                continue
            if teamlist[j+1] == 2:
                teamlist[j+1] = 1
                teamlist[j] = 1
                continue
    else:
        continue
            
print(teamlist.count(0))
