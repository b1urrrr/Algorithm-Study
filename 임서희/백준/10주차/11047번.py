N, K = map(int, input().split())
coins = []

for i in range(N):
    coin= int(input())
    coins.append(coin)
    
count = 0
for coin in coins[::-1]:
    if coin > K:
        continue
    count += (K//coin)
    K %= coin
    
print(count)