# 그리디 알고리즘, 문자열
# 1213번: 팰린드롬 만들기

# 스파이더에선 돌아가는데 런타임에러 나서 아직 다시 구현 중
s = list(input())
s_set = sorted(list(set(s)))
dic = dict()
li = []
for i in s_set:
    dic[i] = 0
    li.append(i)
#print(li)
for i in s:
    dic[i] += 1
res = ''
res_num = 0
res_num_i = []
r=0
for i,j in dic.items():
    res += i*(j//2)
    if j%2 != 0:
        res_num += 1
        res_num_i.append(r)
    r+=1
if res_num > 1:
    print("I'm Sorry Hansoo")
else:
    #print(li[res_num_i[0]])
    print(res+li[res_num_i[0]]+res[::-1])