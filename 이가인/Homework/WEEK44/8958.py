n = int(input())

for _ in range(n):
    score = 0
    cnt = 0
    quiz = input()
    for i in range(len(quiz)):
        if quiz[i] == "O":
            cnt += 1
            score += cnt
        else:
            cnt = 0
    print(score)