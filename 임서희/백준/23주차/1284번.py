# 수학, 구현
# 1284번: 집 주소
num_list = [4,2,3,3,3,3,3,3,3,3]

while True:
    n = input()
    res = 0
    if int(n) == 0:
        break
    for i in n:
        res +=1
        res += num_list[int(i)]
    print(res+1)