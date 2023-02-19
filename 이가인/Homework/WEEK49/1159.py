n = int(input())
name = []
for i in range(n):
    a = input()
    name.append(a[0])

prime_name = set(name)
result = []
for i in prime_name:
    if name.count(i) >= 5:
        result.append(i)

if len(result) > 0:
    print(''.join(sorted(result)))
else:
    print("PREDAJA")