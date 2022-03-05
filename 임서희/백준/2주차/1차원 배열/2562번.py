a = []
i = -1
max = 0

for _ in range(9):
    n = int(input())
    a.append(n)
    if (max < n):
        max = n
        i = _

print(max, i+1)
