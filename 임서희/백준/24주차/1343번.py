# 1343번: 폴리오미노
# 그리디 알고리즘

# s_list에 아직 입력값이 다 안들어와서 다시 풀기
s="XX.XXXXXXXXXX..XXXXXXXX...XXXXXX"
s_list = []
X = ""
dot = ""
for i in s:
    if i != ".":
        X += i
        if len(dot) > 0:
            s_list.append(dot)
            dot = ""
    else:
        if len(X) > 0:
            s_list.append(X)
            X = ""
        dot += i
print(s_list)
res= ""
for i in s_list:
    print(i)
    if 'X' in i:
        if len(i) % 2 == 0:
            res += len(i)//4*"AAAA"
            res += len(i)%4*"B"
        else:
            res = -1
            break
    else:
        res += len(i)*"."
print(res)