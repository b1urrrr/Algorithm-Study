n = int(input())
num = n
for i in range(n):
    temp = input()
    check = []
    for j in range(len(temp)):
        if (temp[j] not in check):
            check.append(temp[j])
            continue
        if len(temp) == len(check):
            continue
        if (temp[j] in check) and (temp[j-1] != temp[j]):
            num -= 1
            break

print(num)