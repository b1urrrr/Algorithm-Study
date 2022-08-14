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