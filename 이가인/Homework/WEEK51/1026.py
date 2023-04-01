n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))

res = 0
for i in range(n):
    # a의 최소값과 b의 최댓값을 곱해 더함
    res += min(a) * max(b)
    a.pop(a.index(min(a)))
    b.pop(b.index(max(b)))
    # 사용한 값들은 삭제

print(res)