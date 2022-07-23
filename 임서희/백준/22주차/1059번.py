# 정렬, 브루트포스 알고리즘
# 1059번: 좋은 구간

# 틀린 내 코드
# 테스트 케이스는 다 맞는데 답이 틀려서 다시 풀어보기
s = int(input())
s_list = list(map(int, input().split()))
s_list = sorted(s_list)
n = int(input())

for i in range(s-1):
    if s_list[i] < n < s_list[i+1]:
        a, b = s_list[i], s_list[i+1]
        break
else:
    a, b = 0, 0

res = 0
if a!=0 and b!=0:
    res = (n-a-1)*(b-n) + (b-n-1)
print(res)