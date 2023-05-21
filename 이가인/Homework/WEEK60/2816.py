n = int(input())

channel = []
for i in range(n):
    name = input()
    if (name == "KBS1"):
        kbs1 = i
    elif (name == "KBS2"):
        kbs2 = i
    channel.append(name)

res = ""
res += '1'*kbs1
res += '4'*kbs1

if kbs1 > kbs2:
    kbs2 += 1

res += '1'*kbs2
res += '4'*(kbs2-1)

print(res)
