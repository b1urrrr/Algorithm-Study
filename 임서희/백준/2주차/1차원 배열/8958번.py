N = int(input())

for _ in range(N):
    score = 0
    n = 1
    quiz = list(input())
    for i in range(len(quiz)):
        if quiz[i] == 'O':
            score += n
            n += 1
        elif quiz[i] == 'X':
            n = 1
    print(f'{score}')
