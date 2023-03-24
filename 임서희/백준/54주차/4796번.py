# 그리디 알고리즘
# 4796번: 캠핑

num = 1

while True:
    L, P, V = map(int, input().split())

    if L + P + V == 0 :
         break
    res = (V//P)*L
    res += min((V%P), L)
    print('Case '+ num +': '+res)

    num+=1