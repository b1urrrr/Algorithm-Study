n, m = map(int, input().split())
l = dict()
for i in range(n):
    value = input()
    l[i] = value
lalpa = {v: k for k,v in l.items()}

for i in range(m):
    find = input()
    if find.isalnum():
        print(l.get(find))
    else:
        print(lalpa.get(find))