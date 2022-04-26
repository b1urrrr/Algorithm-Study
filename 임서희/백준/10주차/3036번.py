N = int(input())
def gcd(A, B):
    while B!=0:
        A,B = B, A%B
    return A

a = list(map(int, input().split()))
for i in range(1, N):
    g = gcd(a[0],a[i])
    aa = a[0] // g
    bb = a[i] // g
    print(f'{aa}/{bb}')