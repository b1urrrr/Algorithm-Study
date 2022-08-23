hear_name = set()
see_name = set()

n, m = map(int, input().split())
for _ in range(n):
    name = input()
    hear_name.add(name)

for _ in range(m):
    name = input()
    see_name.add(name)


res = list((hear_name) & (see_name))
res.sort()
print(len(res))
for i in res:
    print(i)