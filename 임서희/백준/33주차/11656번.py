# 정렬
# 11656번: 접미사 배열
a = input()
a_list = []
for i in range(len(a)):
    a_list.append(a[i:])
a_list = sorted(a_list)

for s in a_list:
    print(s)