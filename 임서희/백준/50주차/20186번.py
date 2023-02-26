# 그리디 알고리즘
# 20186번: 수 고르기
n, k = map(int, input().split())
li = sorted(list(map(int, input().split())), reverse=True)

sum_r = 0
for i in range(k):
    sum_r = sum_r + i
print(sum(li[:k])-sum_r)