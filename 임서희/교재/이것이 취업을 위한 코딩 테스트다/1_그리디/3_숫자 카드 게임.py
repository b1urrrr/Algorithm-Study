# 숫자 카드 게임
# 내가 짠 코드
N, M = map(int, input().split())
n = x = 0

for _ in range(N):
    a = list(map(int, input().split()))
    n = min(a)
    if n > x:
        x = n
        
print(x)

# 그리디 알고리즘 유형의 문제는 문제 해결을 위한 아이디어를 떠올렸다면 정답을 찾을 수 있다.
# 숫자 카드 게임 문제를 푸는 아이디어는 바로 '각 행마다 가장 작은 수를 찾은 뒤에 그 수 중에서 가장 큰 수를 찾는 것'이다.

# 풀이 1: min 함수 이용하기
n, m = map(int, input().split())
result = 0
for i in range(n):
    data = list(map(int, input().split()))
    # 현재 줄에서 가장 작은 수 찾기
    min_value = min(data)
    # 가장 작은 수들 중에서 가장 큰 수 찾기
    result = max(result, min_value) # min_value와 result 값을 비교해서 큰 수가 result

print(result)

# 풀이 2: 2중 반복문 구조 이용하기
n, m = map(int, input().split())
result = 0
for i in range(n):
    data = list(map(int, input().split()))
    # 현재 줄에서 가장 작은 수 찾기
    min_value = 10001
    for a in data:
        min_value = min(min_value, a)
    # 가장 작은 수들 중에서 가장 큰 수 찾기
    result = max(result, min_value)

print(result)