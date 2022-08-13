# 정렬
# 25305번: 커트라인
n, k = map(int, input().split())
n_list = list(map(int,input().split()))
n_list = sorted(n_list,reverse=True)
print(n_list[k-1])