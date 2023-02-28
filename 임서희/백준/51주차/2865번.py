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