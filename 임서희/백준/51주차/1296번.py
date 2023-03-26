# 정렬
# 1296번: 팀 이름 정하기
youn = input()
li = ['L', 'O', 'V', 'E']
k = int(input())

names = []
for _ in range(k):
    names.append(input())
names = sorted(names)
res = ''
max_p = 0

for name in names:
    l = [0 for _ in range(len(li))]
    
    for i in range(len(l)):
        l[i] = name.count(li[i]) + youn.count(li[i]) 
    p = ((l[0]+l[1])*(l[0]+l[2])*(l[0]+l[3])*(l[1]+l[2])*(l[1]+l[3])*(l[2]+l[3])) % 100
    #print(p)
    
    if max_p < p:
        max_p = p
        res = name
print(res)
