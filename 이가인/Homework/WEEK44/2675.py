n = int(input())

for _ in range(t):
    r, s = input().split()
    r = int(r)
    for i in range(len(s)):
        print(s[i]*r, end="")
    print()