# 수학
# 1668번: 트로피 진열

# 테스트케이스 결과는 맞는데 틀려서 다시 풀기
n = int(input())
n_list = list()
for i in range(n):
    n_list.append(int(input()))
left = n_list[0]
left_sum = 1
right = n_list[-1]
right_sum = 1
for i in range(1,n):
    if left < n_list[i]:
        left = n_list[i]
        left_sum += 1
for i in range(n-1,0,-1):
    if right < n_list[i]:
        right = n_list[i]
        right_sum += 1
print(left_sum)
print(right_sum)

# 브루트포스 알고리즘으로 최댓값이 몇 번 갱신되즌지 확인하면 됨!
N = int(input())
li = [int(input()) for _ in range(N)]
left_cnt = right_cnt = 0
left_max = right_max = 0
for n in li:
    if n > left_max:
        left_max = n
        left_cnt += 1
for n in li[::-1]:
    if n > right_max:
        right_max = n
        right_cnt += 1
print(left_cnt)
print(right_cnt)