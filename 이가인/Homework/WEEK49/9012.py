n = int(input())
for i in range(n):
    x = list(input())
    cnt = 0
    for i in x:
        if i == "(":
            cnt += 1
        elif i == ")":
            cnt -= 1
        if cnt < 0:
            print("NO")
            break 
    if cnt > 0:
        print("NO")
    elif cnt == 0:
        print("YES")