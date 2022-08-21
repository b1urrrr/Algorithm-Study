# 비트 마스킹
# 1094번: 막대기
mac = [64, 32, 16, 8, 4, 2, 1]

x = int(input())

first = 0
for i in range(len(mac)):
    if x >= mac[first]:
        first = i
        break
    first += 1
num = mac[first]
res = 1
i = first+1
while True:
    if num == x or i > len(mac):
        break
    if num + mac[i] <= x:
        num += mac[i]
        res += 1
    i += 1
print(res)