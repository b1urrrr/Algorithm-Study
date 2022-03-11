s = input().upper() # 대문자로 변환
s_list = list(set(s))
alpa = []

for i in s_list:
    alpa.append(s.count(i))
    
if alpa.count(max(alpa))>1:
    print("?")
else:
    print(s_list[(alpa.index(max(alpa)))])