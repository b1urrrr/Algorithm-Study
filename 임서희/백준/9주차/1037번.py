# 맞은 내 코드
num = int(input())
a = list(map(int, input().split()))
a.sort()
if len(a) == 1:
    print(a[0]*a[0])
else:
    print(a[0]*a[len(a)-1])

# 다른 사람 코드
# max와 min을 찾아서 곱해주기
n = int(input())
a = list(map(int, input().split()))
a_max = max(a)
a_min = min(a)
print(a_max * a_min)