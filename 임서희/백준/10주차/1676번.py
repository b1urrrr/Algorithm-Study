N = int(input())
global count
count = 0

def fac(a):
    if a == 1:
        return 1
    elif '0' in str(a):
        global count
        count += 1
        return
    return a*fac(a-1)

fac(N)
print(count)