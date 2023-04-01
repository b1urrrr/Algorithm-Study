n, k = map(int, input().split())

a_list = list(map(int, input().split()))

part_sum = sum(a_list[:k])
# print(part_sum)
result_list = [part_sum]

for i in range(len(a_list)-k):
    part_sum = part_sum - a_list[i] + a_list[i + k]    
    result_list.append(part_sum)

print(max(result_list))