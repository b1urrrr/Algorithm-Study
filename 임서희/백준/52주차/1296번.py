# 정렬
# 1296번: 팀 이름 정하기

# 51주차에 틀렸어서 다시 재풀이
# 참고: https://jinho-study.tistory.com/522
youn = input()
k = int(input())

names = []
for _ in range(k):
    names.append(input())
names = sorted(names)
max_p= max_i = 0

for i in range(k):
    L = youn.count("L") + names[i].count("L")
    O = youn.count("O") + names[i].count("O")
    V = youn.count("V") + names[i].count("V")
    E = youn.count("E") + names[i].count("E")
    p = ((L+O)*(L+V)*(L+E)*(O+V)*(O+E)*(V+E)) % 100

    if max_p < p:
        max_p = p
        max_i = i
print(names[max_i])