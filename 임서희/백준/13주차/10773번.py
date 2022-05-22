# 스택
# 10773번: 제로
n = int(input())
stack = []

for _ in range(n):
    a = int(input())
    if a != 0:
        stack.append(a)
    else:
        stack.pop()

print(sum(stack))