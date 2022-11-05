# 정렬
# 13904번: 지난주차에 못풀었어서 다른 사람 코드 참고
# 점수를 기준으로 정렬하는 것까지는 맞게 접근함.
# 내림차순으로 점수를 기준으로 정렬을 하면서, 가장 높은 점수를 최대한 나중에 수행하는 방식으로 구현해야 했음
import sys
N = int(sys.stdin.readline())
homeworks = []
visit = [False] * 1001

for _ in range(N):
    d, w = map(int, sys.stdin.readline().split())
    homeworks.append((d, w))

homeworks.sort(key=lambda x: x[1], reverse=True)
answer = 0
for day, worth in homeworks:
    i = day
    # 과제를 할 날짜 탐색
    while i > 0 and visit[i]:
        i -= 1
    # 과제를 할 날짜가 없으면 패스
    if i == 0:
        continue
    else:
        visit[i] = True
        answer += worth

print(answer)