# 정렬
# 11292번: 키 큰 사람
while True:
    n = int(input())
    if n == 0:
        break
    li = list()
    for i in range(n):
        li.append(list(map(str, input().split())))
    li = sorted(li, key = lambda x:x[1], reverse=True)
    max_i = li[0][1]
    print(li[0][0], end =' ')
    for i in range(1,n):
        if max_i == li[i][1]:
            print(li[i][0], end = ' ')
    