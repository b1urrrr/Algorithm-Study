# 브루트포스 알고리즘, 다이나믹 프로그래밍
# 14501번: 퇴사

# 예제 입력 4는 적용이 안돼서 DP로 생각해보기
n = int(input())
n_list = []
n_list[0] = 0
for _ in range(n+1):
    t, p = map(int, input().split())
    n_list.append([t,p])
l = 1
res = 0
while l > n:
    res += n_list[l][1]
    l += n_list[l][0]
