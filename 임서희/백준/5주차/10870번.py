N = int(input())

def fivo(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fivo(n-1) + fivo(n-2)

print(fivo(N))
