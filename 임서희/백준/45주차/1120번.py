# 문자열, 브루트포스
# 1120번: 문자열
# 모든 경우의 수를 체크하여 최솟값을 출력하는 방법
# koder과 topcoder의 경우
# 1. (koder)
#    (topco)der
# 2. (koder)
#   t(opcod)er
# 3  (koder)
#  to(pcode)r
# 4. (koder)
# top(coder)

a, b = map(str, input().split())

result = []
for i in range(len(b)-len(a) + 1):
    cnt = 0
    for j in range(len(a)):
        if a[j] != b[i+j]:
            cnt += 1
    result.append(cnt)
print(min(result))