# 브루트포스 알고리즘
# 6159번: 코스튬 파티

# 내 코드: 시간초과 -> 더 생각해보기
# 시간 초과 문제는 pypy로 수정하니 해결
# 메모리 초과가 발생해서 set을 받는 부분을 없애고, res로 카운트하도록 변수 생성해서 이중 for문 돌리기
import sys
n, s = map(int, sys.stdin.readline().rstrip().split())
li = list()
for _ in range(n):
    li.append(int(sys.stdin.readline()))

res = 0
for i in range(n-1):
    for j in range(i+1, n):
        if (li[i]+li[j]) <= s:
            res += 1
print(res)
