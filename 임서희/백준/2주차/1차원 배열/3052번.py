# 다시 보기
a = []

for _ in range(10):
    n = int(input())
    a.append(n % 42)

s = set(a)  # set함수로 중복 제거 ('서로 다른' 값이 몇 개 있는지)
print(len(s))
