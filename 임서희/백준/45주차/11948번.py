# 수학, 구현
# 11948번: 과목 선택
science = []
history = []

for _ in range(4):
    science.append(int(input()))

for _ in range(2):
    history.append(int(input()))

science.sort(reverse=True)
history.sort(reverse=True)

print(sum(science[:3]) + history[0])
