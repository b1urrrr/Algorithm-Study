n = int(input())
s = input()
num = [int(input()) for _ in range(n)]
stack = []

for i in s:
    if i.isalpha():
        stack.append(num[ord(i) - ord('A')])
    else:
        b = stack.pop()
        a = stack.pop()
        if i == '+':
            stack.append(a + b)
        elif i == '-':
            stack.append(a - b)
        elif i == '*':
            stack.append(a * b)
        else:
            stack.append(a / b)

print(f'{stack[0]:.2f}')
