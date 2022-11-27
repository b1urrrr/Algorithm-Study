# 정렬
# 1755번: 숫자 놀이
m, n = map(int, input().split())
num = {0:'zero', 1:'one', 2:'two', 3:'three', 4:'four', 5:'five',
6:'six', 7:'seven', 8:'eight', 9:'nine'}
num_reverse = {v:k for k,v in num.items()}
num_list = []
for i in range(m,n+1):
    alpha = list(str(i))
    res = ''
    for j in alpha:
        res += num[int(j)] + ' '
    num_list.append(res[:-1])
num_list.sort()
cnt = 0
for n in num_list:
    li = n.split()
    res = ''
    for i in li:
        res += str(num_reverse.get(i))
    print(int(res), end = ' ')
    cnt += 1
    if cnt % 10 == 0:
        print()