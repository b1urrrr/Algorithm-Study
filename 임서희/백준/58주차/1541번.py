# 그리디 알고리즘
# 1541번: 잃어버린 괄호

arr = input().split('-')
s = 0
for i in arr[0].split('+'): 
    s += int(i)
for i in arr[1:]:
    for j in i.split('+'): 
        s -= int(j)
print(s)