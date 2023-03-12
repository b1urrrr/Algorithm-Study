# 첫번째 시도
# n = int(input())
# cnt = 0
# if n == 1 or n == 2 or n == 4:
#     print(0)
# elif n == 3:
#     print(1)
# else:
#     for i in range(1, n-1):
#         for j in range(i, n-1):
#             k = n - i - j #k는 가장 긴 변
#             if (j > k): 
#                 break
#             if (i+j > k):
#                 cnt += 1
#     print(cnt)

n = int(input())
cnt = 0
for x in range(1, n-1):
    for y in range(x, n-1):
        z = n - x - y
        if y <= z and x + y > z:
            cnt += 1

print(cnt)
