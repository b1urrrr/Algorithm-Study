# 그리디 알고리즘
# 2872번: 우리집엔 도서관이 있어

# 규칙 찾기가 생각보다 어려워서 코드 참고함
# 다시 풀어보기
import sys
input = lambda: sys.stdin.readline().rstrip()
N = int(input())
books = [int(input()) for _ in range(N)]

find_target = N
answer = 0
for i in range(N-1, -1, -1):
    if books[i] != find_target:
        answer += 1
    else:
        find_target -= 1

print(answer)