# 해시와 맵
# 1302번: 베스트 셀러
# 틀린 내 풀이: 리스트 정렬 → 딕셔너리
n = int(input())
li = []
for i in range(n):
    li.append(input())
li = sorted(li) # 딕셔너리에 집어넣기 전에 리스트 정렬하면 같은 value 가진 딕셔너리에서 사전순 출력이 될거라 생각했는데 틀림
li_set = set(li)
li_dic = dict()

for i in li_set:
    li_dic[i] = 0

for i in li:
    li_dic[i] += 1
    
print(li_dic)
print(max(li_dic,key=li_dic.get))

# 다른 사람 코드 참고해서 수정한 코드
# 딕셔너리 → 리스트 정렬
n = int(input())
dic = dict()
for i in range(n):
    a = input()
    if a in dic:
        dic[a] += 1
    else:
        dic[a] = 1

li = []
max_num = max(dic.values())

for i in dic:
    if max_num == dic[i]:
        li.append(i)
li = sorted(li)
print(li[0])