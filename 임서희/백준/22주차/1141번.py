# 정렬, 문자열
# 1141번: 접두사
i = int(input())
li = list()
for _ in range(i):
    li.append(input())

li = sorted(li)
print(li)
new_li = list()
for i in range(len(li)):
    for j in range(i, len(li)-1):
        if li[i] == li[j+1][:len(li[i])]:
            break
    else:
        new_li.append(li[i])

print(len(new_li))