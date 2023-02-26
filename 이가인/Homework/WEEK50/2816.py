n = int(input())
channel = []
for i in range(n):
    name = input()
    if name == 'KBS1':
        idx1 = i
    elif name == 'KBS2':
        idx2 = i
    channel.append(name)

res = ''
res += '1' * idx1
res += '4' * idx1
if idx1 > idx2:
    idx2 += 1

res += '1' * idx2
res += '4' * (idx2-1)
print(res)