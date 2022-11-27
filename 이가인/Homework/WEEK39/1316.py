n = int(input())
num = n
for i in range(n):
    temp = input()
    check = []
    for j in range(len(temp)):
        if (temp[j] not in check):
            check.append(temp[j])
            continue    # 앞에 중복되는 문자가 없었다면 추가함
        if len(temp) == len(check):
            continue    # 두 문자열의 길이가 같다면 그룹단어임
        if (temp[j] in check) and (temp[j-1] != temp[j]):
            num -= 1
            break    # 만약 check 문자열에 있는데, 앞의 문자와 다른 문자라면 그룹단어가 아님

print(num)