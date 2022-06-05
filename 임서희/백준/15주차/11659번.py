# 누적합
# 11659번: 구간 합 구하기 4

# 시간 초과
n, m = map(int, input().split())
n_list = list(map(int, input().split()))

for _ in range(m):
    s = 0
    i, j = map(int, input().split())
    for k in range(i-1, j):
        s += n_list[k]
    print(s)

# 위처럼 배열의 구간에서 원소를 일일이 훑으며 더하면 시간 복잡도가 O(N^2)에 가까워져서
# 성능이 좋지 않다. 그래서 시간 초과가 발생한다.

# 따라서 입력 받은 배열을 '누적 합의 배열'로 바꾸고 i, j에 해당하는 두 원소의 차를 구하면
# 그 구간의 합을 구하게 되는 방식을 사용한다.

# 예제: [5, 4, 3, 2, 1]
# 누적합(pfs): [0, 5, 9, 12, 14, 15]
# 구간 i, j의 합을 구하고 싶다면 pfs[j] - pfs[i-1] 을 해주면 간단히 구할 수 있다.

# 즉, 빠르게 누적합을 구하기 위해선 '누적합의 배열'을 만들고 구간의 차를 구하면 된다.
import sys
n,m = map(int, sys.stdin.readline().split())
pfs=list(map(int,sys.stdin.readline().split()))
for i in range(n-1):
    pfs[i+1] += pfs[i] # 이전에 있던 합을 누적해서 더해준다.
pfs = [0] + pfs # 첫번째에 0 원소 추가

for _ in range(m):
    i, j = map(int, sys.stdin.readline().split())
    print(pfs[j]-pfs[i-1])