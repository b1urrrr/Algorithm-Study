# 정렬, 문자열
# 6996번: 애너그램
n = int(input())
for _ in range(n):
    a1, b1 = input().split()
    a, b = list(a1), list(b1)
    a = sorted(a)
    b = sorted(b)
    l = True
    if len(a) != len(b):
        l = False
    else:
        for i in range(len(a)):
            if a[i] != b[i]:
                l = False
    if l:
        print(a1 + ' & ' + b1 + ' are anagrams.')        
    else:
        print(a1 + ' & ' + b1 + ' are NOT anagrams.')