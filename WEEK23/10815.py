N = int(input())
a = list(map(int, input().split()))
a.sort()

def binary_search(num):
    l = 0
    r = N-1
    while l <= r:
        mid = (l+r)//2
        if a[mid] == num:
            return 1
        elif a[mid] > num:
            r = mid - 1
        else:
            l = mid + 1
    return 0

input()
for num in list(map(int, input().split())):
    print(binary_search(num), end=' ')