# 그리디 알고리즘
# 2865번: 나는 위대한 슈퍼스타K

# 문제를 잘못 이해했어서 다시 풀기 -> 다른 장르로 생각함
# 같은 장르여도 되는 것을 고려하기
n, m, k = map(int, input().split())
li = []
for _ in range(m):
     li_s = list(map(float, input().split()))
     li.append([int(li_s[0]), li_s[1]])
li = sorted(li, key = lambda x:x[1], reverse=True)

cnt = 0
s = 0
s_l = dict()
for i in li:
    if cnt == k:
        break
    if i[0] not in s_l:
        s_l[i[0]] = i[1]
        cnt += 1
        s += 1
    else:
        continue
print(s_l)

# 코드 참고
import sys

# N: 예선 참가자 수, M: 장르, K: 본선 진출자 수
N, M, K = map(int, input().split())

score = {}
for i in range(N):
    score[i+1] = 0

for i in range(M):
    li = list(map(float, input().split()))
    for j in range(0, 2*N, 2):
        if li[j+1] > score[li[j]]:
            score[li[j]] = li[j+1]

score = sorted(list(score.values()), reverse=True)
s = sum(score[:K])
print('%.1f' % s)