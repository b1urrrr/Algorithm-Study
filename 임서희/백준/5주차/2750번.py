N = int(input())
a = []
for _ in range(N):
    i = int(input())
    a.append(i)
a.sort()

for i in range(len(a)):
    print(a[i])