# 브루트포스 알고리즘
# 1526번: 가장 큰 금민수
n = int(input())
num_list = ['0','1','2','3','5','6','8','9']
while True:
    n_list = list(str(n))
    for i in num_list:
        if i in n_list:
            n -= 1
            break
    else:
        print(n)
        break