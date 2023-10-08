def isPrime(n):
    if n == 1:
        return False
    for i in range(2, int(n**(1/2))+1):
        if n % i == 0:
            return False
    return True

n = int(input())
result = 0

for i in range(n, 10000001):
    if i == 1:
        continue
    if str(i) == str(i) [::-1] and isPrime(i):
        result = i
        break

if result == 0:
    print(1003001)

print(result)