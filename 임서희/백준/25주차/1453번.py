# 구현
# 1453번: 피시방 알바

n = int(input())
n_list = list(map(int,input().split()))
n_set = list(set(n_list))
print(len(n_list)-len(n_set))