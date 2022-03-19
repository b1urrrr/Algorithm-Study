# 틀린 내 코드: 실패
N = int(input())
i = 0
recent = 0
r = True

while N >= 0:
    if (N - 5 >= 5 or N-5 == 0) and r:
        N -= 5
        recent = 5
        i += 1
    elif (N - 3 >= 3 or N-3==0):
        N -= 3
        recent = 3
        i += 1
    elif 0 < N < 3:
        i -= 1
        N += recent
        r = False
    else:
        i = -1
        break
print(i)

# 정상적인 다른 코드
sugar = int(input())
bag = 0

while sugar >= 0:
    if sugar % 5 == 0:
        bag += (sugar // 5)
        print(bag)
        break
    sugar -= 3
    bag += 1
else:
    print(-1)