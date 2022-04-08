# 맞는 내 코드
N = int(input())
a = []
b = -1
for _ in range(N):
    x, y = map(int, input().split())
    a.append((x,y))
    
score = [1] * len(a)

for i in range(len(a)):
    b = i
    for k in range(len(a)):
        if b == k: # 이거 안 해도 어차피 같으면 아래 if에 해당 안되므로 생략 가능
            continue
        if a[i][0] < a[k][0] and a[i][1] < a[k][1]:
            score[i] += 1

for num in score:
    print(num, end=' ')


# 다른 사람 코드
l = []

for _ in range(int(input())):
    x,y = map(int, input().split())
    l.append((x,y))

for i in l:
    rank = 1
    for c in l:
        if (c[0] > i[0]) & (c[1] > i[1]):
            rank +=1
    print(rank)     
