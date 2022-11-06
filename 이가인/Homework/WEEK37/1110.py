# 시간초과 오답
# N = int(input())
# cnt = 0

# while True:
#     a = N // 10
#     b = N % 10
#     c = a + b
#     new_num = N%10*10 + c

#     cnt += 1
#     if (N == new_num):
#         break

# print(cnt)

#정답 풀이

# 자료 입력
N = int(input())

# 문제 풀이
check = N 
temp = 0
new_N = 0
cycle_count = 0

while True:
    temp = (N//10) + (N%10)
    new_N = (N % 10)*10 + (temp % 10)
    cycle_count += 1
    N = new_N 
    if new_N == check: 
        break

print(cycle_count)