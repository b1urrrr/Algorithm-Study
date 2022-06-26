# 수학, 정렬, 그리디 알고리즘
# 1026번: 보물
n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
a = sorted(a)
b_list = sorted(b, reverse=True)
s = 0
for i in range(n):
    s += a[i] * b_list[i]
print(s)