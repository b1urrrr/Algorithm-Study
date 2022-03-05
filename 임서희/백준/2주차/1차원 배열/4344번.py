C = int(input())

for _ in range(C):
    n = 0
    sum = 0
    score = list(map(int, input().split()))
    for i in range(1, len(score)):
        sum += score[i]
    avg = sum/score[0]  # avg = sum(score[1:])/score[0]
    for i in range(1, len(score)):
        if score[i] > avg:
            n += 1
    print(f'{n*100/score[0]:.3f}%')
