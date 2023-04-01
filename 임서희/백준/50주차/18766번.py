# 정렬
# 18766번: 카드 바꿔치기

t = int(input())

for _ in range(t):
    n = int(input())
    g_card = sorted(list(map(str, input().split())))
    d_card = sorted(list(map(str, input().split())))

    if g_card == d_card:
        print("NOT CHEATER")
    else:
        print("CHEATER")